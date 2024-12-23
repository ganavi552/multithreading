package com.multithreading.suspend_resume;

public class SharedResource {

    boolean isAvailable = false;

    public synchronized  void produce(){
        System.out.println("Lock Acquired by " + Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            //handle exception
        }
        System.out.println("Lock released by " + Thread.currentThread().getName());
    }
}
