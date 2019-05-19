package exercise.alibaba;

public class SingleModle {
    private volatile static SingleModle singleModle;
    private SingleModle (){}
    public static SingleModle getSingleModle() {
        if (singleModle == null) {
            synchronized (SingleModle.class) {
                if (singleModle == null) {
                    singleModle = new SingleModle();
                }
            }
        }
        return singleModle;
    }
}