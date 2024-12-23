package com.multithreading.suspend_resume;

public class DaemonMain {
    public static void main(String[] args){
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " calls produce method");
            resource.produce();
        });

        th1.setDaemon(true);
        th1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread completes its work.");

    }
}
