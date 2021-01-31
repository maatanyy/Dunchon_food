package org.techtown.food;

public class Recfood {
    int resId;
    String name;
    String price;


    public Recfood(int resId, String name, String price) {
        this.resId = resId;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
