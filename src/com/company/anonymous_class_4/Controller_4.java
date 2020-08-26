package com.company.anonymous_class_4;

import com.company.Controllers;

public class Controller_4 implements Controllers
{
    @Override
    public void execute() {
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

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\anonymous_class_4\\Massage.txt");
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
