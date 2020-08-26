package com.company.inner_class_3;

import com.company.Controllers;


public class Controller_3 implements Controllers {

    private int k = 5;

    public static void main(String[] args) {
//        Inner inner = new Inner(); // can not

        Controller_3 controller = new Controller_3();
        Inner inner = controller.new Inner();

    }

    @Override
    public void execute() {
        Inner inner = new Inner();
        inner.print();
        System.out.println("t = " + inner.t);

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\inner_class_3\\Massage.txt");
    }

    public void method (){
        class NewInner {
            void someMethod(){
                System.out.println("Text");
            }
        }

        NewInner newInner = new NewInner();
        newInner.someMethod();
    }

    class Inner {
        private int t = 6;

        private void print() {
            System.out.println("k = " + k);
        }

        void print(String text) {
            System.out.println(k + t + " = K + T");
            System.out.println(text);

        }
    }
}

class Second {
    void method() {
        Controller_3.Inner inner = new Controller_3().new Inner();
        inner.print("Second class");
    }
}
