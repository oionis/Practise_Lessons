package com.company.generics_2;

import com.company.Controllers;

public class GenericInheritance implements Controllers {

    @Override
    public void execute() {
        //        Parent parent = new GenParent();
        GenParent genParent = new Child();
        GenParent<String> genParent1 = new Child4<String>();
        GenParent<String> genParent2 = new Child5<Integer, Object, String>();
        Child5<Double, String, Integer> child5 = new Child6<Double, Object, String>();

    }
}


class Parent{}
class GenParent<T> extends Parent{}

class Child extends GenParent{}
class Child2 extends GenParent<String>{}
class Child3<T> extends GenParent{}
class Child4<T> extends GenParent<T>{}
class Child5<X, Y, T> extends GenParent<T>{}
class Child6<X, Y, T> extends Child5<X, String, Integer>{}


interface GenericInterface<T>{
    T getT();
}

class First implements GenericInterface{
    @Override
    public Object getT() {
        return null;
    }
}

class Second implements GenericInterface<String>{
    @Override
    public String getT() {
        return null;
    }
}

class Third<T> implements GenericInterface<T>{
    @Override
    public T getT() {
        return null;
    }
}