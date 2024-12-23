package com.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {
    public static void main(String[] args) {
        //here we have 3 different objects and we have to call a method but we have to wait for a thread to completes its process in that method.
        // no two threads with different objects cant call critical region[method] at same time >> this is the requirement

        //we cant use "synchronized " >> bcs this applies lock based up on shared resouce /object
        // for above requirement we have to use custom lock.

      /*  ReentrantLock lock = new ReentrantLock();
        SharedResourceWithReentrantLockAsArg resource1 = new SharedResourceWithReentrantLockAsArg();
        Thread th1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " calling produce method");
            resource1.produce(lock);
        });
        ReentrantLock lock1 = new ReentrantLock();
        SharedResourceWithReentrantLockAsArg resource2 = new SharedResourceWithReentrantLockAsArg();
        Thread th2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " calling produce method");
//            resource2.produce(lock);
            resource2.produce(lock1);
        });

        th1.start();
        th2.start();*/

        SharedResourceWithReentrantLock resource1 = new SharedResourceWithReentrantLock();
        Thread th1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " calling produce method");
            resource1.produce();
        });

        Thread th2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " calling produce method");
            resource1.produce();
        });

        th1.start();
        th2.start();

        System.out.println("Main thread completes its work");
    }
}
