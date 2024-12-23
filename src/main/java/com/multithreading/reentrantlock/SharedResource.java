package com.multithreading.reentrantlock;

public class SharedResource {
    boolean isAvailable = false;


    public synchronized void produce(){
        System.out.println("Lock acquired by " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Lock released by " + Thread.currentThread().getName());
    }
}
