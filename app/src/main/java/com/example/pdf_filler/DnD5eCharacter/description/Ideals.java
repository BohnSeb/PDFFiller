package com.example.pdf_filler.DnD5eCharacter.description;

public class Ideals extends SingleTextfieldType{
    public Ideals(String ideals){
        super(ideals);
    }

    public String getPersonality(){
        return this.getText();
    }

    public void setPersonality(String ideals){
        this.setText(ideals);
    }
}
