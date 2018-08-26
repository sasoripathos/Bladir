package com.bladir.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="standard")
public class Standard {

    @Id
    @Column(name="value_name")
    private String valuename;

    @Column(name="low")
    private double low;

    @Column(name="high")
    private double high;

    @OneToMany(mappedBy="standard",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Record> results;


    public Standard() {

    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public Standard(double low, double high, String value_name) {
        this.low = low;
        this.high = high;
        this.valuename = value_name;
    }


}
