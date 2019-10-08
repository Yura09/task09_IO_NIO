package com.epam.app.serialization.sport;


import java.io.Serializable;

public class Sportsmen extends Human implements Serializable {
    private TypeOfSport typeOfSport;
    private transient int rate;

    public Sportsmen(String name, int age, String typeOfSport, int rate) {
        super(name, age);
        try {
            this.typeOfSport = TypeOfSport.valueOf(typeOfSport.toUpperCase());
        } catch (IllegalArgumentException e) {
            this.typeOfSport = TypeOfSport.valueOf("SWIMMING");
        }

        this.rate = rate;
    }

    public String getTypeOfSport() {
        return typeOfSport.getTypeOfSport();
    }

    @Override
    public String toString() {
        return "Sportsmen{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", typeOfSport=" + getTypeOfSport() + ", rate=" + rate +
                '}';
    }
}
