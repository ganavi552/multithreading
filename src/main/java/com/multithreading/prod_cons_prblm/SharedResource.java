package com.multithreading.prod_cons_prblm;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    Queue<Integer> sharedBuffer;
    private int bufferSize;

    SharedResource(Queue<Integer> sharedBuffer, int size){
        this.sharedBuffer = sharedBuffer;
        this.bufferSize = size;
    }

     public synchronized void producer(Integer item){
        //if Buffer is full ,wait for the consumer to consume items
        while(sharedBuffer.size() == bufferSize) {
            System.out.println("Buffer is full, producer is waiting for consumer");
            try {
                wait();
            } catch (InterruptedException e) {
                //handle exception here
            }
        }
        sharedBuffer.add(item);
        System.out.println("Thread " + Thread.currentThread().getName() + " added item " + item + " to buffer");
        //notify the consumer,that there are items to consume
        notify();
    }

     public synchronized int consumer(){
        //Buffer is empty, wait for producer to produce items
        while(sharedBuffer.isEmpty()) {
            System.out.println("Buffer is Empty not able to consume");
            try {
                wait();
            } catch (InterruptedException e) {
                //handle exception here
            }
        }
        int item = sharedBuffer.poll();
        System.out.println("Thread " + Thread.currentThread().getName() + " consumed item " + item + " from  buffer");
        //notify the producer, that there is space in buffer now.
        notify();
        return item;
    }

    
}
