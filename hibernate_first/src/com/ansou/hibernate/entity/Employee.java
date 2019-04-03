package com.ansou.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="compnay")
    private String compnay;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String compnay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.compnay = compnay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompnay() {
        return compnay;
    }

    public void setCompnay(String compnay) {
        this.compnay = compnay;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " , firstName: " + this.firstName + " , lastName: " + this.lastName + " , company: " + this.compnay;
    }
}
