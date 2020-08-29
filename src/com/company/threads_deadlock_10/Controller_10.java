package com.company.threads_deadlock_10;

import com.company.Controllers;

public class Controller_10 implements Controllers {
    @Override
    public void execute() {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.resourceA = resourceA;
        myThread2.resourceB = resourceB;

        myThread1.start();
        myThread2.start();

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\threads_deadlock_10\\Massage.txt");
    }
}

class MyThread1 extends Thread{
    ResourceA resourceA;
    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class MyThread2 extends Thread{
    ResourceB resourceB;
    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA {
    ResourceB resourceB;

    synchronized int getI() {
        return resourceB.returnI();
    }

    synchronized int returnI() {
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;

    synchronized int getI() {
        return resourceA.returnI();
    }

    synchronized int returnI() {
        return 2;
    }
}