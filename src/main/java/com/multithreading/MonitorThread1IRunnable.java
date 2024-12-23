package com.multithreading;

public class MonitorThread1IRunnable implements Runnable {
    MonitorLockExample obj;

    public MonitorThread1IRunnable(MonitorLockExample obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.task1();
    }
}
