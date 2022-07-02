package com.example.pdf_filler.DnD5eCharacter.description;

public class Description {
    private Personality personality;
    private Ideals ideals;
    private Bonds bonds;
    private Flaws flaws;

    public Description(Personality personality, Ideals ideals, Bonds bonds, Flaws flaws){
        this.personality = personality;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
    }

    public Personality getPersonality() {
        return personality;
    }

    public Ideals getIdeals() {
        return ideals;
    }

    public Bonds getBonds() {
        return bonds;
    }

    public Flaws getFlaws() {
        return flaws;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public void setIdeals(Ideals ideals) {
        this.ideals = ideals;
    }

    public void setBonds(Bonds bonds) {
        this.bonds = bonds;
    }

    public void setFlaws(Flaws flaws) {
        this.flaws = flaws;
    }
}
