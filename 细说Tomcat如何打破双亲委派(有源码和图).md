[细说Tomcat如何打破双亲委派(有源码和图)](https://blog.csdn.net/iteye_18979/article/details/82604271)

# 细说Tomcat如何打破双亲委派(有源码和图)

一句话概况: 不考虑缓存, 那么装载路径就是,先Classpath, 然后War包,当前工程, 最后才是Tomcat相关目录. 不考虑缓存,是因为缓存只是用来加快速度,对外不调用展现出的逻辑效果是可以忽略的.

 

下图是一个概况的流程图, 简介起见,绘图过程中移除了缓存功能. (个了感觉还是有些逻辑还是有些复杂的,图画出来了,自己看着都觉得还是不清楚,但是也没发现可以改进的地方)

 


![img](http://dl2.iteye.com/upload/attachment/0100/9486/81418f1d-7fe7-39f8-9ff5-5d264b0f3503.jpg)
 

下面是关键的代码,已经添加了注释.

```
//WebappClassLoader.loadClass (Tomcat 7.0)
 
 
    @Override
    public synchronized Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException {
 
        if (log.isDebugEnabled())
            log.debug("loadClass(" + name + ", " + resolve + ")");
        Class<?> clazz = null;
 
//检查当前ClassLoad是否已经停止了
        // Log access to stopped classloader
        if (!started) {
            try {
                throw new IllegalStateException();
            } catch (IllegalStateException e) {
                log.info(sm.getString("webappClassLoader.stopped", name), e);
            }
        }
 
//检查缓存1,Class是否已经被当前Class"实例"装载过
       // (0) Check our previously loaded local class cache
        clazz = findLoadedClass0(name);
        if (clazz != null) {
            if (log.isDebugEnabled())
                log.debug(" Returning class from cache");
            if (resolve)
                resolveClass(clazz);
            return (clazz);
        }
//ClassLoader检查缓存2,Class是否已经被父类"实例"装载过
        // (0.1) Check our previously loaded class cache
        clazz = findLoadedClass(name);
        if (clazz != null) {
            if (log.isDebugEnabled())
                log.debug(" Returning class from cache");
            if (resolve)
                resolveClass(clazz);
            return (clazz);
        }
 
//ClassLoader装载系统classpath下面的类, 阻止webapp覆盖了J2SE的类
        // (0.2) Try loading the class with the system class loader, to prevent
        // the webapp from overriding J2SE classes
        try {
            clazz = system.loadClass(name);
            if (clazz != null) {
                if (resolve)
                    resolveClass(clazz);
                return (clazz);
            }
        } catch (ClassNotFoundException e) {
            // Ignore
        }
 
//安全检查
        // (0.5) Permission to access this class when using a SecurityManager
        if (securityManager != null) {
            int i = name.lastIndexOf('.');
            if (i >= 0) {
                try {
                    securityManager.checkPackageAccess(name.substring(0,i));
                } catch (SecurityException se) {
                    String error = "Security Violation, attempt to use " +
                        "Restricted Class: " + name;
                    log.info(error, se);
                    throw new ClassNotFoundException(error, se);
                }
            }
        }
 
//默认的返回值为false, 
//delegate = false
//filter(name) 通过一个List指定哪些package里面的Class使用双亲委派模式,但是默认这个List是空
//比如包名以Java开头的,就需要使用双亲委派模式,不过这一点"部分"由 (0.2) 在上面已经实现了
        boolean delegateLoad = delegate || filter(name);
 
//针对一些明确指定的package,使用双亲委派模式加载
        // (1) Delegate to our parent if requested
        if (delegateLoad) {
            if (log.isDebugEnabled())
                log.debug(" Delegating to parent classloader1 " + parent);
            ClassLoader loader = parent;
            if (loader == null)
                loader = system;
            try {
                clazz = Class.forName(name, false, loader);
                if (clazz != null) {
                    if (log.isDebugEnabled())
                        log.debug(" Loading class from parent");
                    if (resolve)
                        resolveClass(clazz);
                    return (clazz);
                }
            } catch (ClassNotFoundException e) {
                // Ignore
               //如果(1)通过双亲委派加载发生异常, 忽略异常,
            }
        }
 
     
        //尝试从本地加载Class( 如果(1)通过双亲委派加载发生异常, 忽略异常,也会走到这一步)
        // (2) Search local repositories
        if (log.isDebugEnabled())
            log.debug(" Searching local repositories");
        try {
            clazz = findClass(name);
            if (clazz != null) {
                if (log.isDebugEnabled())
                    log.debug(" Loading class from local repository");
                if (resolve)
                    resolveClass(clazz);
                return (clazz);
            }
        } catch (ClassNotFoundException e) {
            // Ignore
        }
 
//最后依旧没有成功, 忽略所有配置,再次尝试一下双亲加载模式加载
        // (3) Delegate to parent unconditionally
        if (!delegateLoad) {
            if (log.isDebugEnabled())
                log.debug(" Delegating to parent classloader at end: " + parent);
            ClassLoader loader = parent;
            if (loader == null)
                loader = system;
            try {
                clazz = Class.forName(name, false, loader);
                if (clazz != null) {
                    if (log.isDebugEnabled())
                        log.debug(" Loading class from parent");
                    if (resolve)
                        resolveClass(clazz);
                    return (clazz);
                }
            } catch (ClassNotFoundException e) {
                // Ignore
            }
        }
 
//最后如果依旧没有成功,则抛出异常
        throw new ClassNotFoundException(name);
 
    }
```

