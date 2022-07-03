package com.example.pdf_filler.DnD5eCharacter.description;

import com.example.pdf_filler.DnD5eCharacter.SingleTextfieldType;

public class Flaws extends SingleTextfieldType {
    public Flaws(String flaws){
        super(flaws);
    }

    public void setFlaws(String flaws){
        this.setText(flaws);
    }
}
