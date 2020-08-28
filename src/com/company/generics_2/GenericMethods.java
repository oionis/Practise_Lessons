package com.company.generics_2;

import com.company.Controllers;

import java.io.IOException;

public class GenericMethods implements Controllers {

    @Override
    public void execute() {
        Cell<String> cell = new Cell<>();
        System.out.println(cell.method(5));
        cell.<Integer>method2(545);
    }
}

class Cell <T>{
    T t;

    Cell(){}

    <X> Cell (X x){}

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <T> T method (T t){
        return t;
    }

    <F> void method2 (F f){
        System.out.println(f);
    }

}

// Как выглядит код выше в Байткоде

//class Cell{
//    Object t;
//
//    public Object getT() {
//        return t;
//    }
//
//    public void setT(Object t) {
//        this.t = t;
//    }
//}