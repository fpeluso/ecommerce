package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "DEMO_TABLE")
public class DemoEntityModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String field1;
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
