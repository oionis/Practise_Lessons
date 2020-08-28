package com.company.threads_synhronized_7;

import com.company.Controllers;

public class Controller_7 implements Controllers {
    @Override
    public void execute() {

        Resources resources = new Resources();
        resources.setI(5);
        Resources.j = 6;

        MyThread myThread1 = new MyThread();
        myThread1.setResources(resources);
        myThread1.setName("First");

        MyThread myThread2 = new MyThread();
        myThread2.setResources(resources);

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I = " + myThread1.resources.getI() + " J = " + Resources.j);
    }
}

class MyThread extends Thread {

    Resources resources;

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        resources.changeI();
        Resources.changeStaticI();
    }
}

class Resources {
    int i;

    static int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    static synchronized void changeStaticI() {
        int j = Resources.j;
//        synchronized (Resources.class) {   // --- Так записывается для статического метода
        if (Thread.currentThread().getName().equals("First")) {
            Thread.yield();
        }
        j++;
        Resources.j = j;
//        }
    }

    synchronized void changeI() {
        // Если этот метод не синхронизировать, может получиться ситуация когда сначала начнёт выполнятся первый блок,
        // он прервётся, а после запустится второй, и часть информации потеряется
        // Должно быть 7, а может получиться 6

        int i = this.i;

        //   synchronized (this) {   // --- Как вариант, можно заключать синхронизируемый код в такой блок
        if (Thread.currentThread().getName().equals("First")) {
            Thread.yield();
        }
        i++;
        this.i = i;
        //   }
    }
}