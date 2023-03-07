package com.example.superheltev_4.model;

public class Superhero {
    private String name;
    private String superpower;
    private boolean human;
    private int introYear;
    private double strengthPoints;

    public Superhero(String name, String superPower, boolean human, int introYear, double strengthPoints) {
        this.name = name;
        this.superpower = superPower;
        this.human = human;
        this.introYear = introYear;
        this.strengthPoints = strengthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public int getIntroYear() {
        return introYear;
    }

    public void setIntroYear(int introYear) {
        this.introYear = introYear;
    }

    public double getStrengthPoints() {
        return strengthPoints;
    }

    public void setStrengthPoints(double strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    public String toString() {
        return ("Name: " + name + "\n" + "Superpower: " + superpower + "\n" + "Human: " + human
                + "\n" + "Introduction year: " + introYear + "\n" + "Strength points: " + strengthPoints + " \n ");
    }
}
