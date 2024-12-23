package com.multithreading.prod_cons_prblm;

import java.util.LinkedList;

public class Main {

    public static void main (String[] args) {
        SharedResource sharedResource = new SharedResource(new LinkedList<>(), 3);

        Thread producerThread = new Thread(() -> {
            for(int i = 1 ; i <= 6 ; i++) {
                sharedResource.producer(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i = 1 ; i <= 6 ; i++) {
                sharedResource.consumer();
            }
        });

        producerThread.start();
        consumerThread.start();

    }

}
