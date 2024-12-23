package com.multithreading.suspend_resume;

public class Main {
    public static void main(String[] args){
        SharedResource resource = new SharedResource();

        Thread th1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " calls produce method");
            resource.produce();
        });

        Thread th2 = new Thread(()->{
            //making thread2 to sleep for 1s so that thread1 start and acquires lock.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " calls produce method");
            resource.produce();
        });

        th1.start();
        th2.start();

        // make main thread to sleep for 3s so that thread2 calls produce and wait for lock before main thread completes its work
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        th1.suspend();

        th1.resume();
        System.out.println("Main thread completes its work.");

    }
}
