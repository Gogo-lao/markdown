package exercise.alibaba;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadABC {
    private volatile static int count = 0;

    public static void main(String[] args) {
        Lock rtLock = new ReentrantLock();
        Thread A = new Thread(new Runnable(){
            @Override
            public void run() {
                while (count<=30) {
                    rtLock.lock();
                    if(count%3==0){
                        System.out.print("A");
                        count ++;
                    }
                    rtLock.unlock();
                }
            }
        });

        Thread B = new Thread(new Runnable(){
            @Override
            public void run() {
                while (count<=30) {
                    rtLock.lock();
                    if(count%3==1){
                        System.out.print("B");
                        count ++;
                    }
                    rtLock.unlock();
                }
            }
        });

        Thread C = new Thread(new Runnable(){
            @Override
            public void run() {
                while (count<=30) {
                    rtLock.lock();
                    if(count%3==2){
                        System.out.print("C");
                        count ++;
                    }
                    rtLock.unlock();
                }
            }
        });

        A.start();
        B.start();
        C.start();
    }
}