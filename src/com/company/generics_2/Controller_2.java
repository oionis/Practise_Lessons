package com.company.generics_2;

import com.company.Controllers;

import java.io.IOException;


public class Controller_2 implements Controllers {
    @Override
    public void execute() throws IOException {
//        Controllers controllers = new GenericInheritance();
//        Controllers controllers = new GenericMethods();
//        Controllers controllers = new Bounds();
        Controllers controllers = new WildCard();
        controllers.execute();

        controllers.massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\generics_2\\Massage.txt");
    }



}

