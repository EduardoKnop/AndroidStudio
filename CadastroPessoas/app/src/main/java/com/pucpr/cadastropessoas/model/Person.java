package com.pucpr.cadastropessoas.model;

import com.pucpr.cadastropessoas.model.persistance.PersonDAO;

import java.io.File;

public class Person {

    private int id;
    private String name;
    private long birthDate;
    private short age;
    private char sex;
    private String hometown;
    private String nationality;
    private File photo;


    public Person(String name, long birthDate, char sex,
                  String hometown, String nationality) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.hometown = hometown;
        this.nationality = nationality;

        //this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }
}
