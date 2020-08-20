package com.company;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public interface Controllers {
    void execute() throws IOException;
    default void massage(String fileName) {
        System.out.println("--------------------------------------------------------------");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    };
}
