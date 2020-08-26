package com.company.cloning_5;

import com.company.Controllers;

public class Controller_5 implements Controllers {
    @Override
    public void execute(){

        SomeClass someClass1 = new SomeClass();
        someClass1.setI(1);
        System.out.println(someClass1.getI());
        SomeClass someClass2 = someClass1;
        someClass2.setI(2);
        System.out.println(someClass1.getI());
        SomeClass someClass3 = someClass1.clone();
        someClass3.setI(3);
        System.out.println(someClass1.getI());

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\cloning\\Massage.txt");

    }
}

class SomeClass implements Cloneable{
    private int i;
    SecondClass secondClass;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    protected SomeClass clone() {
        try {
            SomeClass someClass = (SomeClass) super.clone();
            someClass.secondClass = secondClass.clone();
            return someClass;
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}

class SecondClass implements Cloneable{
    int j;

    @Override
    protected SecondClass clone() throws CloneNotSupportedException {
        return (SecondClass) super.clone();
    }
}
