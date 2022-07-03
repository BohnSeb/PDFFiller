package com.example.pdf_filler.DnD5eCharacter;

public abstract class SingleTextfieldType {
    private String text;

    public SingleTextfieldType(String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }
}
