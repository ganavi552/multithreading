package com.multithreading.reentrantlock;

public class SynchronizedMonitorLockMain {
    public static void main(String[] args) {

        //sychronized >> applies monitor lock based on object . if we call synchronized method by two threads
        // with same obj then second thread has to wait for lock

        // if object differs then no need to wait.
        SharedResource resource1 = new SharedResource();
        Thread th1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "calling produce method");
            resource1.produce();
        });

        SharedResource resource2 = new SharedResource();
        Thread th2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "calling produce method");
            resource2.produce();
        });

        th1.start();
        th2.start();

        System.out.println("Main thread completes its work");
    }
}
