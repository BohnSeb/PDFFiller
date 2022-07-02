package com.example.pdf_filler.DnD5eCharacter.description;

public class Bonds extends SingleTextfieldType{
    public Bonds(String bonds){
        super(bonds);
    }

    public String getPersonality(){
        return this.getText();
    }

    public void setPersonality(String bonds){
        this.setText(bonds);
    }
}
