package com.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResourceWithReentrantLockAsArg {
    boolean isAvailable = false;

    public void produce(ReentrantLock lock){

        try {
            lock.lock();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }
        catch (Exception e) {
//            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock released by " + Thread.currentThread().getName());
            lock.unlock();

        }
    }
}
