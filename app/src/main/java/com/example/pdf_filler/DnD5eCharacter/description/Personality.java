package com.example.pdf_filler.DnD5eCharacter.description;

import com.example.pdf_filler.DnD5eCharacter.SingleTextfieldType;

public class Personality extends SingleTextfieldType {
    public Personality(String personality){
        super(personality);
    }

    public void setPersonality(String personality){
        this.setText(personality);
    }
}
