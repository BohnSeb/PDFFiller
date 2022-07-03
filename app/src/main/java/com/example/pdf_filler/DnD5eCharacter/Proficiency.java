package com.example.pdf_filler.DnD5eCharacter;

public enum Proficiency {
    NONE(0d),
    FULL(1d),
    EXPERT(2d),
    JACK_OF_ALL_TRAITS(0.5);

    private final Double modificator;

    Proficiency(Double modificator){
        this.modificator = modificator;
    }

    public static Proficiency getProficiency(String description){
        if (description.equals("NONE")){return NONE;}
        if (description.equals("FULL")){return FULL;}
        if (description.equals("EXPERT")){return EXPERT;}
        if (description.equals("JOAT")){return JACK_OF_ALL_TRAITS;}
        throw new RuntimeException("Couldn't get Proficiency Type of:" + description);
    }

    public Double modificator(){
        return this.modificator;
    }
}
