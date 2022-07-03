package com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore;

public class AbilityScore {
    private final String name;
    private final int score;
    private final int mod;

    public AbilityScore(String name, int score){
        this.name = name;
        this.score = score;
        this.mod = (score - 10 > 0) ? (int) Math.floor((score - 10 )/ 2) : (int) Math.ceil((score - 10)/2);
    }

    public int getScore(){return this.score;}

    public int getMod(){return this.mod;}

    public String getName(){return this.name;}
}
