package com.company.generics_2;

import com.company.Controllers;

import java.io.IOException;

public class WildCard implements Controllers {
    @Override
    public void execute() throws IOException {
        NewCell<? extends Car> newCell = new NewCell<>();
        Car car = newCell.getT();
//        cell.setT(new Toyota());  // ---- can not


        NewCell <? super Toyota> newCel2 = new NewCell<Car>();
        newCel2.setT(new Camry());
        newCel2.setT(new Toyota());
//        Toyota toyota = cell2.getT();  // ---- can not
    }
}


class Car{}
class Toyota extends Car{}
class Camry extends Toyota{}

class NewCell <T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}