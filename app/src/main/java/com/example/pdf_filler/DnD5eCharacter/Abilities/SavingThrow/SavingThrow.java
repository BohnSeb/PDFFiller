package com.example.pdf_filler.DnD5eCharacter.Abilities.SavingThrow;

import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScore;
import com.example.pdf_filler.DnD5eCharacter.progression.Progression;

public class SavingThrow {
    private final String name;
    //private final boolean proficient;
    private final int mod;

    public SavingThrow(String name, AbilityScore score, boolean proficient, Progression progression){
        this.name = name;
        int proficiencyBonus = progression.getProficiency();
        this.mod = calcModifier(proficient, proficiencyBonus, score.getMod());
    }

    private int calcModifier(boolean prof, int bonus, int mod){
        if (prof){
            return bonus + mod;
        }
        return mod;
    }

    public int getMod(){
        return this.mod;
    }

    public String getName(){return this.name;}

    @Override
    public String toString(){
        return Integer.toString(this.mod);
    }
}
