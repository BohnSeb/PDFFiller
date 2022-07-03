package com.example.pdf_filler.DnD5eCharacter.progression;

public class Level {
    private int lvl;

    public Level(int lvl){
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }

    @Override
    public String toString(){return Integer.toString(this.getLvl());}

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
