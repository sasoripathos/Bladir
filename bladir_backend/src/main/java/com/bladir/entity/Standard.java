package com.bladir.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="standard")
public class Standard {

    @Id
    @Column(name="value_name")
    private String value_name;

    @Column(name="low")
    private double low;

    @Column(name="high")
    private double high;

    @OneToMany(mappedBy="standard",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Result> results;


    public Standard() {

    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
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
        this.value_name = value_name;
    }


}
