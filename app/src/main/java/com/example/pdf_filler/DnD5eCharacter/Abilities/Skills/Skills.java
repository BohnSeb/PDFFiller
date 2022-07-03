package com.example.pdf_filler.DnD5eCharacter.Abilities.Skills;

import java.util.HashMap;

public class Skills {
    private HashMap<String, Skill> skills;

    public Skills(){
        this.skills = new HashMap<String, Skill>();
    }

    public Skills(Skill[] skills){
        for (int i = 0; i < skills.length; i++){
            this.skills.put(skills[i].getName(), skills[i]);
        }
    }

    public void addSkill(Skill skill){
        this.skills.put(skill.getName(), skill);
    }

    public Skill getSkill(String name){
        return this.skills.get(name);
    }
}
