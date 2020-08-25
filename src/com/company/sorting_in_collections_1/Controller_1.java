package com.company.sorting_in_collections_1;

import com.company.Controllers;

import java.io.*;
import java.util.Deque;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Controller_1 implements Controllers {
    @Override
    public void execute() {

        Set set = new TreeSet(new ComparePerson());
        set.add(new Person(16, "John"));
        set.add(new Person(13, "Stiv"));
        set.add(new Person(20, "Frederik"));
        for (Object person : set){
            System.out.println( person);
        }

        massage("E:\\SelfDevelopment\\Java\\Practise_Lessons\\src\\com\\company\\sorting_in_collections_1\\Massage.txt");

    }


}
