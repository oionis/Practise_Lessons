package com.company.threads_volatile_atomic_8;

import com.company.Controllers;

import java.util.concurrent.atomic.AtomicInteger;

public class Controller_8 implements Controllers {

    volatile static int i = 0;
    static int k = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void execute() {
//        new MyThreadReader().start();
//        new MyThreadWriter().start();

        for (int j = 0; j < 50_000; j++) {
            new MyThreadForAtomic().start();
        }

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicInteger.get()); // Атомарн
        System.out.println(k); // Обычная переменная может записаться не корректно. В ходе выполнения операций, некоторые значения могут потерятся. Из-за особенностей многопоточности.

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\threads_volatile_atomic_8\\Massage.txt");
    }

    static class MyThreadWriter extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("Increment I, I = " + (++i));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadReader extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) {
                    System.out.println("New value of I = " + i);
                    localVar = i;
                }
            }
        }
    }

    static class MyThreadForAtomic extends Thread{
        @Override
        public void run() {
            nonAtomicChangeI();
            atomicChangeI();
        }

        void atomicChangeI(){
            atomicInteger.addAndGet(1);
        }

        void nonAtomicChangeI(){
            int p = k + 1;
            k = p;
        }
    }

}
