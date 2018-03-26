package com.example.smita.imageslider;

import android.widget.TextView;


public class Categories {
    private String foodvariety,fooddetails;
    private int foodvarietyimg;

    public Categories(String foodvariety, String fooddetails, int foodvarietyimg) {
        //
        this.foodvariety = foodvariety;
        this.fooddetails = fooddetails;
        this.foodvarietyimg = foodvarietyimg;
    }

    public String getFoodvariety() {
        return foodvariety;
    }

    public void setFoodvariety(String foodvariety) {
        this.foodvariety = foodvariety;
    }

    public String getFooddetails() {
        return fooddetails;
    }

    public void setFooddetails(String fooddetails) {
        this.fooddetails = fooddetails;
    }

    public int getFoodvarietyimg() {
        return foodvarietyimg;
    }

    public void setFoodvarietyimg(int foodvarietyimg) {
        this.foodvarietyimg = foodvarietyimg;
    }
}
