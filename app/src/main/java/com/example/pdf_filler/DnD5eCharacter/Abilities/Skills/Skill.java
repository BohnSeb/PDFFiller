package com.example.pdf_filler.DnD5eCharacter.Abilities.Skills;

import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScore;
import com.example.pdf_filler.DnD5eCharacter.Proficiency;
import com.example.pdf_filler.DnD5eCharacter.progression.Progression;

public class Skill {
    private final String name;
    private final int mod;

    public Skill(String name, AbilityScore score, Proficiency proficiency, Progression progression){
        this.name = name;
        this.mod = calcModifier(score, proficiency, progression.getProficiency());
    }

    private int calcModifier(AbilityScore score, Proficiency proficiency, int proficiencyBonus) {
        return (int) Math.floor(proficiencyBonus * proficiency.modificator()) + score.getMod();
    }

    public String getName(){return this.name;}

    public int getMod(){return this.mod;}
}
