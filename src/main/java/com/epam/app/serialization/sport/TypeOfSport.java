package com.epam.app.serialization.sport;


public enum TypeOfSport {
    SWIMMING("Swimming"), BOX("Box"), FOOTBALLER("Footballer");

    private String companyLetter;

    private TypeOfSport(String s) {
        companyLetter = s;
    }

    public String getTypeOfSport() {
        return companyLetter;
    }


}
