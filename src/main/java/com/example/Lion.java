package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Feline wild;

    public Lion(String sex, Feline wild) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.wild = wild;
    }

    public int getKittens() {
        return wild.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return wild.getFood("Хищник");
    }
}
