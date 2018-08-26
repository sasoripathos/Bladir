package com.bladir.entity;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="test")
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date")
    private Date date;

    @Column(name="test_comment")
    private String testcoment;

    @OneToMany(mappedBy="test", fetch=FetchType.LAZY,
            cascade={CascadeType.DETACH,CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    private List<Record> records;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="patient_id")
    private User user;

    public Test() {
    	
    }
    
    public Test(Date date, String testcoment, List<Record> records, User user) {
        this.date = date;
        this.testcoment = testcoment;
        this.records = records;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTestcoment() {
        return testcoment;
    }

    public void setTestcoment(String testcoment) {
        this.testcoment = testcoment;
    }
}
