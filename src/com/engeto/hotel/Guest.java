package com.engeto.hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Guest {
    private final String NAME;
    private final String SURNAME;
    private Date birthDate;

    public Guest(String name, String surname, Date birthDate) {
        this.NAME = name;
        this.SURNAME = surname;
        this.birthDate = birthDate;
    }

    public String getFullName(){
        return NAME + " " + SURNAME;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate() {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(birthDate);
    }

    public String getCzechFormattedBirthDate() {
        final SimpleDateFormat sdf = new SimpleDateFormat("d. M. yyyy");
        return sdf.format(birthDate);
    }

    public String getDescription() {
        return getFullName() + " (" + getCzechFormattedBirthDate() + ")";
    }
}
