package com.example.pdf_filler.DnD5eCharacter.Abilities;

import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScore;

public enum Abilityscores {
    STRRENGTH("str"),
    DEXTERITY("dex"),
    CONSTITUTION("con"),
    INTELLIGENCE("int"),
    WISDOM("wis"),
    CHARISMA("cha");

    private final String abbreviation;

    private Abilityscores(String name){
        this.abbreviation = name;
    }

    @Override
    public String toString(){
        return this.abbreviation;
    }
}
