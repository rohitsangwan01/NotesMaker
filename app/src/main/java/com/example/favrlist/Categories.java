package com.example.favrlist;

import java.util.ArrayList;

public class Categories {
    public String name;
    public ArrayList<String> item = new ArrayList<>();

    public Categories(String name, ArrayList<String> item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getItem() {
        return item;
    }
}
