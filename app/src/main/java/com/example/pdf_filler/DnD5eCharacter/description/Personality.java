package com.example.pdf_filler.DnD5eCharacter.description;

public class Personality extends SingleTextfieldType{
    public Personality(String personality){
        super(personality);
    }

    public String getPersonality(){
        return this.getText();
    }

    public void setPersonality(String personality){
        this.setText(personality);
    }
}
