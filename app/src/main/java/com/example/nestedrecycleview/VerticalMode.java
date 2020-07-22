package com.example.nestedrecycleview;

import java.util.ArrayList;

public class VerticalMode {
    String  title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArrayList(ArrayList<HorizontalMode> arrayList) {
        this.arrayList = arrayList;
    }

    ArrayList<HorizontalMode> arrayList;

    public String getTitle() {
        return title;
    }

    public ArrayList<HorizontalMode> getArrayList() {
        return arrayList;
    }
}
