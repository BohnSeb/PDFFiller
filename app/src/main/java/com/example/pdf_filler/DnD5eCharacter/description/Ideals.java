package com.example.pdf_filler.DnD5eCharacter.description;

import com.example.pdf_filler.DnD5eCharacter.SingleTextfieldType;

public class Ideals extends SingleTextfieldType {
    public Ideals(String ideals){
        super(ideals);
    }

    public void setPersonality(String ideals){
        this.setText(ideals);
    }
}
