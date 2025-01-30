package com.engeto.hotel;

public class Guest {
    private String name;
    private String surname;
    private String birthDate;

    public Guest(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getFullName(){
        return name + " " + surname;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
