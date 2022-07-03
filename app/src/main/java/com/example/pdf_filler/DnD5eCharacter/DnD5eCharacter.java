package com.example.pdf_filler.DnD5eCharacter;

import com.example.pdf_filler.DnD5eCharacter.Abilities.Abilities;
import com.example.pdf_filler.DnD5eCharacter.description.Description;
import com.example.pdf_filler.DnD5eCharacter.progression.Progression;

public class DnD5eCharacter {
    private String name;
    private Description description;
    private Progression progression;
    private Abilities abilities;

    public DnD5eCharacter(String name, Description description, Progression progression, Abilities abilities){
        this.name = name;
        this.description = description;
        this.progression = progression;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Progression getProgression() {
        return progression;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" ");
        sb.append(this.progression.getLevel());
        return sb.toString();
    }
}
