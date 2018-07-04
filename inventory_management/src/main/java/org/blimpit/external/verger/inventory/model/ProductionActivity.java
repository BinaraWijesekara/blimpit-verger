package org.blimpit.external.verger.inventory.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductionActivity {

    private int year;
    private int month;
    private int day;
    private String activity;

     public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
