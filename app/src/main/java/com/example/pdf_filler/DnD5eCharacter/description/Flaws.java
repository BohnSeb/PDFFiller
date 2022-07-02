package com.example.pdf_filler.DnD5eCharacter.description;

public class Flaws extends SingleTextfieldType{
    public Flaws(String flaws){
        super(flaws);
    }

    public String getFlaws(){
        return this.getText();
    }

    public void setFlaws(String flaws){
        this.setText(flaws);
    }
}
