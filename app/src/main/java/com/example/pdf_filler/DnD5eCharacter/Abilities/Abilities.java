package com.example.pdf_filler.DnD5eCharacter.Abilities;

import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScores;
import com.example.pdf_filler.DnD5eCharacter.Abilities.SavingThrow.SavingThrows;
import com.example.pdf_filler.DnD5eCharacter.Abilities.Skills.Skills;

public class Abilities {
    private AbilityScores scores;
    private SavingThrows saves;
    private Skills skills;

    public Abilities(AbilityScores scores, SavingThrows saves, Skills skills){
        this.scores = scores;
        this.saves = saves;
        this.skills = skills;
    }

    public AbilityScores getAbilityScores(){return this.scores;}

    public SavingThrows getSavingThrows(){return this.saves;}

    public Skills getSkills(){return this.skills;}
}
