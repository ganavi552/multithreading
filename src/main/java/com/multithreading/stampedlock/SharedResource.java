package com.multithreading.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void produce(){
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic read ");
            a = 11;
            Thread.sleep(6000);
            if(lock.validate(stamp)) {
                System.out.println("Updated a Value successfully");
            } else {
                System.out.println("rollback of work");
                a = 10;
            }
        } catch(Exception e) {
            //handle exception here
        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        System.out.println("write lock acquired by " + Thread.currentThread().getName());
        try {
            System.out.println("performing work");
//            Thread.sleep(6000);
            a = 9;
        } catch(Exception e){
            //handle exception here.
        }
        finally{
            lock.unlockWrite(stamp);
            System.out.println("write lock released by " + Thread.currentThread().getName());
        }

    }
}
