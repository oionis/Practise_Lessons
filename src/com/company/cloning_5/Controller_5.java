package com.company.cloning_5;

import com.company.Controllers;

public class Controller_5 implements Controllers {
    @Override
    public void execute(){

        SomeClass someClass1 = new SomeClass();
        someClass1.setI(1);
        someClass1.secondClass = new SecondClass(5);
        System.out.println("I = " + someClass1.getI() + "   SecondClass.J = " + someClass1.secondClass.j);
        SomeClass someClass2 = someClass1;
        someClass2.setI(2);
        someClass2.secondClass = new SecondClass(6);
        System.out.println("I = " + someClass1.getI() + "   SecondClass.J = " + someClass1.secondClass.j);
        SomeClass someClass3 = someClass1.clone();
        someClass3.setI(3);
        someClass3.secondClass = new SecondClass(7);
        System.out.println("I = " + someClass1.getI() + "   SecondClass.J = " + someClass1.secondClass.j);

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\cloning_5\\Massage.txt");

    }
}

class SomeClass implements Cloneable{
    int i;
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
        } catch (CloneNotSupportedException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}

class SecondClass implements Cloneable{
    int j;

    public SecondClass(int j) {
        this.j = j;
    }

    public SecondClass() {
    }

    @Override
    protected SecondClass clone() throws CloneNotSupportedException {
        return (SecondClass) super.clone();
    }
}
