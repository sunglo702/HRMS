package com.dmu.hrms.bean;

public class Dept {
    private Integer id;
    private String name;

    private Emp emp;
    private Position position;
    public Dept() {
    }
    public Dept(Integer id, String name,Position position, Emp emp) {
        this.id = id;
        this.name = name;
        this.position=position;
        this.emp=emp;
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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
