package com.multithreading;

public class ConsumeTask implements Runnable {
    SharedResource sharedResource;

    ConsumeTask(SharedResource resource){
        this.sharedResource = resource;
    }


    @Override
    public void run() {
        System.out.println("Consumer Thread " + Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
}
