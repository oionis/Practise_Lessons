package com.company.threads_6;

import com.company.Controllers;

public class Controller_6 implements Controllers {
    @Override
    public void execute() {

        System.out.println(Thread.currentThread().getName());
        new MyTread().start();
        new Thread(new MyRunnable()).start();

        System.out.println("\n---------------\n");

        new NewThread().start();
        new NewThread().start();
        new NewThread().start();

        Thread.yield();

        NewThread newThread = new NewThread();
        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\threads_6\\Massage.txt");
    }
}

class MyTread extends Thread{
    @Override
    public void run() {
        printNameThread();
    }

    private void printNameThread(){
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        printNameThread();
    }

    private void printNameThread() {
        System.out.println(Thread.currentThread().getName());
    }
}

class NewThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Current thread name = " + Thread.currentThread().getName() + "  i = " + i);
        }
    }
}