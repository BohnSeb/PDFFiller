package com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore;

import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScore;

import java.util.HashMap;

public class AbilityScores {
    private HashMap<String, AbilityScore> scores;

    public AbilityScores(){
        this.scores = new HashMap<String, AbilityScore>();
    }

    public AbilityScores(AbilityScore[] scores){
        this.scores = new HashMap<String, AbilityScore>();
        for (int i = 0; i < scores.length; i++){
            this.scores.put(scores[i].getName(), scores[i]);
        }
    }

    public void addScore(AbilityScore score){
        this.scores.put(score.getName(), score);
    }

    public AbilityScore getAbilityScore(String name){
        return this.scores.get(name);
    }
}
