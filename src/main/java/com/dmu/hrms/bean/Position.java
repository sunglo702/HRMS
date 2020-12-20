package com.dmu.hrms.bean;

public class Position {
    private Integer id;
    private String name;
    public Integer did;

    private Dept dept;
    public Position() {
    }

    public Position(Integer id, String name, Integer did) {
        this.id = id;
        this.name = name;
        this.did=did;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept(){return dept;}

    public void setDept(Dept dept){this.dept=dept;}
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }
}
