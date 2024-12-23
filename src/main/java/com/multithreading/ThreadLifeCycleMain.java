package com.multithreading;

public class ThreadLifeCycleMain {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

//        Thread producerThread = new Thread( new ProduceTask(sharedResource));
//        Thread consumerThread = new Thread(new ConsumeTask(sharedResource));

        //using lambda.
        Thread producerThread = new Thread( () ->{
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
              //handle exception.
            }
            sharedResource.addItem();
        });
        Thread consumerThread = new Thread(sharedResource::consumeItem);

        producerThread.start();
        consumerThread.start();

    }

}
