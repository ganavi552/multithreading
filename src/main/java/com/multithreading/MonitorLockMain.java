package com.multithreading;

public class MonitorLockMain {
    public  static  void main(String[] args) {
        MonitorLockExample obj = new MonitorLockExample();

        //thread creation.
        MonitorThread1IRunnable runnableObj = new MonitorThread1IRunnable(obj);
        Thread thread1 = new Thread(runnableObj);


        Thread thread2 = new Thread(obj::task2);
        Thread thread3 = new Thread(obj::task3);

        //thread start
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
