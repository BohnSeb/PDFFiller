package com.example.pdf_filler.DnD5eCharacter.Abilities.SavingThrow;

import com.example.pdf_filler.DnD5eCharacter.Abilities.SavingThrow.SavingThrow;

import java.util.HashMap;

public class SavingThrows {
    private HashMap<String, SavingThrow> savingThrows;

    public SavingThrows(){
        this.savingThrows = new HashMap<String, SavingThrow>();
    }

    public SavingThrows(SavingThrow[] savingThrows){
        this.savingThrows = new HashMap<String, SavingThrow>();
        for (int i = 0; i < savingThrows.length; i++){
            this.savingThrows.put(savingThrows[i].getName(), savingThrows[i]);
        }
    }

    public void addSavingThrow(SavingThrow save){
        this.savingThrows.put(save.getName(), save);
    }

    public SavingThrow getSavingThrow(String name){
        return this.savingThrows.get(name);
    }
}
