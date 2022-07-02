package com.example.pdf_filler.DnD5eCharacter;

import com.example.pdf_filler.DnD5eCharacter.description.Description;
import com.example.pdf_filler.DnD5eCharacter.progression.Progression;

public class DnD5eCharacter {
    private String name;
    private Description description;
    private Progression progression;

    public DnD5eCharacter(Description description){
        this.description = description;
    }
}
