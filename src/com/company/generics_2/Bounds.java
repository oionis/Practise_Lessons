package com.company.generics_2;

import com.company.Controllers;

import java.io.IOException;
import java.io.Serializable;

public class Bounds implements Controllers {
    @Override
    public void execute() throws IOException {
        SomeClass<Job> someClass = new SomeClass<>();
        someClass.doJod();

        SomeClass<ChildJob> someClass2 = new SomeClass<>();
        someClass2.doJod();
    }
}

class Job implements Serializable {
    void doIt(){
        System.out.println("Do it");
    }
}

class ChildJob extends Job{}

class SomeClass <T extends Job & Serializable>{
    T t;
    void doJod(){
        t.doIt();
    }
}