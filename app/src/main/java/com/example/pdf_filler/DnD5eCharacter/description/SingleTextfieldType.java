package com.example.pdf_filler.DnD5eCharacter.description;

abstract class SingleTextfieldType {
    private String text;

    public SingleTextfieldType(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }
}
