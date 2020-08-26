package com.company.anonymous_class_4;

import com.company.Controllers;

import java.io.IOException;

public class Controller_4 implements Controllers
{

    @Override
    public void execute() throws IOException {
        SomeClass someClass = new SomeClass(){
            @Override
            void firstMethod(){
                System.out.println("Main");
            }
        };

        someClass.firstMethod();
        someClass.secondMethod();

        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        comparable.compareTo(someClass);


        methodInController(new SomeClass(){
            @Override
            void secondMethod() {
                System.out.println("Override second method");
            }
        });

    }

    void methodInController(SomeClass someClass){
        someClass.secondMethod();
    }

}

class SomeClass{
    void firstMethod(){
        System.out.println("Some Class");
    }

    void secondMethod(){
        System.out.println("Second method");
    }

}
