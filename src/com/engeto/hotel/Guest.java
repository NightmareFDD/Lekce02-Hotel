package com.engeto.hotel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Guest {
    private final String NAME;
    private final String SURNAME;
    private final LocalDate birthDate;

    public Guest(String name, String surname, LocalDate birthDate) {
        this.NAME = name;
        this.SURNAME = surname;
        this.birthDate = birthDate;
    }

    public String getFullName(){
        return NAME + " " + SURNAME;
    }

    public String getCzechFormattedBirthDate() {
        final SimpleDateFormat sdf = new SimpleDateFormat("d. M. yyyy");
        return sdf.format(birthDate);
    }

    public String getDescription() {
        return getFullName() + " (" + getCzechFormattedBirthDate() + ")";
    }
}
