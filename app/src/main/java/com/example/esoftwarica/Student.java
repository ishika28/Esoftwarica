package com.example.esoftwarica;

public class Student
{

    private String name;
    private String age;
    private String address;
    private String gender;
    private int imgperson;
    private int imgdelete;

    public Student(String name, String age, String address, String gender, int imgperson, int imgdelete) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.imgperson = imgperson;
        this.imgdelete = imgdelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImgperson() {
        return imgperson;
    }

    public void setImgperson(int imgperson) {
        this.imgperson = imgperson;
    }

    public int getImgdelete() {
        return imgdelete;
    }

    public void setImgdelete(int imgdelete) {
        this.imgdelete = imgdelete;
    }
}
