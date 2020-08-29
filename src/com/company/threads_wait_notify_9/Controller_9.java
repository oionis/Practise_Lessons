package com.company.threads_wait_notify_9;

import com.company.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Controller_9 implements Controllers {

    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void execute() {

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\threads_wait_notify_9\\Massage.txt");

        new Operator().start();
        new Machine().start();


    }

    static class Operator extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (strings) {
                    strings.add(scanner.nextLine());
                    strings.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Machine extends Thread {
        @Override
        public void run() {
            while (strings.isEmpty()) {
                synchronized (strings) {
                    try {
                        strings.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(strings.remove(0));
                }
            }
        }
    }
}
