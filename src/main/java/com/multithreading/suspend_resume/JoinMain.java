package com.multithreading.suspend_resume;

public class JoinMain {
    public static void main(String[] args){
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " calls produce method");
            resource.produce();
        });

        th1.start();
        try {
            System.out.println("Main thread is waiting till Thread- 0 completes");
            th1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread completes its work.");

    }
}
