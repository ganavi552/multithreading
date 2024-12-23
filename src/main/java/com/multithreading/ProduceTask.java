package com.multithreading;

public class ProduceTask implements Runnable {
    SharedResource sharedResource;

    ProduceTask(SharedResource obj){
      this.sharedResource = obj;
    }

    @Override
    public void run() {
        System.out.println("Producer Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            //exception handling here.
        }
        sharedResource.addItem();
    }
}
