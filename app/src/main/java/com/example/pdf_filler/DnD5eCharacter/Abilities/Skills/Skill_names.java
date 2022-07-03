package com.example.pdf_filler.DnD5eCharacter.Abilities.Skills;

public enum Skill_names {
    ACROBATICS("ACROBATICS"),
    ANIMAL_HANDLING("ANIMAL_HANDLING"),
    ARCANA("ARCANA"),
    ATHLETICS("ATHLETICS"),
    DECEPTION("DECEPTION"),
    HISTORY("HISTORY"),
    INSIGHT("INSIGHT"),
    INTIMIDATION("INTIMIDATION"),
    INVESTIGATION("INVESTIGATION"),
    MEDICINE("MEDICINE"),
    NATURE("NATURE"),
    PERCEPTION("PERCEPTION"),
    PERFORMANCE("PERFORMANCE"),
    PERSUASION("PERSUASION"),
    RELIGION("RELIGION"),
    SLEIGHT_OF_HAND("SLEIGHT_OF_HAND"),
    STEALTH("STEALTH"),
    SURVIVAL("SURVIVAL");

    private final String name;

    private Skill_names(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
