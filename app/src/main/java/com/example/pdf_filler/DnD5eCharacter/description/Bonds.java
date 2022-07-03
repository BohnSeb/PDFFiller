package com.example.pdf_filler.DnD5eCharacter.description;

import com.example.pdf_filler.DnD5eCharacter.SingleTextfieldType;

public class Bonds extends SingleTextfieldType {
    public Bonds(String bonds){
        super(bonds);
    }

    public void setPersonality(String bonds){
        this.setText(bonds);
    }
}
