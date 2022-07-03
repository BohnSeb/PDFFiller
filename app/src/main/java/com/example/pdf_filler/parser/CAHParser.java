package com.example.pdf_filler.parser;

import com.example.pdf_filler.DnD5eCharacter.Abilities.Abilities;
import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScore;
import com.example.pdf_filler.DnD5eCharacter.Abilities.AbilityScore.AbilityScores;
import com.example.pdf_filler.DnD5eCharacter.Abilities.Abilityscores;
import com.example.pdf_filler.DnD5eCharacter.Abilities.SavingThrow.SavingThrow;
import com.example.pdf_filler.DnD5eCharacter.Abilities.SavingThrow.SavingThrows;
import com.example.pdf_filler.DnD5eCharacter.Abilities.Skills.Skill;
import com.example.pdf_filler.DnD5eCharacter.Abilities.Skills.Skill_names;
import com.example.pdf_filler.DnD5eCharacter.Abilities.Skills.Skills;
import com.example.pdf_filler.DnD5eCharacter.DnD5eCharacter;
import com.example.pdf_filler.DnD5eCharacter.Proficiency;
import com.example.pdf_filler.DnD5eCharacter.description.Bonds;
import com.example.pdf_filler.DnD5eCharacter.description.Description;
import com.example.pdf_filler.DnD5eCharacter.description.Flaws;
import com.example.pdf_filler.DnD5eCharacter.description.Ideals;
import com.example.pdf_filler.DnD5eCharacter.description.Personality;
import com.example.pdf_filler.DnD5eCharacter.progression.Progression;
import com.example.pdf_filler.DnD5eCharacter.progression.XP;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CAHParser {
    public CAHParser(){}

    public DnD5eCharacter parse(JSONObject cah) throws JSONException {
        String name = cah.getString("name");
        Description desc = parseDescription(cah);
        Progression progression = new Progression(new XP(cah.getInt("exp")));
        Abilities abilities = parseAbilities(cah, progression);
        return new DnD5eCharacter(name, desc, progression, abilities);
    }

    private Description parseDescription(JSONObject root) throws JSONException {
        Ideals ideals = new Ideals(root.getString("ideals"));
        Bonds bonds = new Bonds(root.getString("bonds"));
        Flaws flaws = new Flaws(root.getString("flaws"));
        Personality personality = new Personality(root.getString("personalityTraits"));
        return new Description(personality, ideals, bonds, flaws);
    }

    private Abilities parseAbilities(JSONObject root, Progression progression) throws JSONException {
        AbilityScores scores = parseAbilityScores(root);
        Skills skills = parseSkills(root.getJSONArray("skills"), scores, progression);
        SavingThrows saves = parseSavingThrows(root, scores, progression);
        return new Abilities(scores, saves, skills);
    }

    private AbilityScores parseAbilityScores(JSONObject root) throws JSONException{
        AbilityScores scores = new AbilityScores();
        AbilityScore str = new AbilityScore(Abilityscores.STRRENGTH.toString(),root.getJSONObject("strength").getInt("score"));
        scores.addScore(str);
        AbilityScore dex = new AbilityScore(Abilityscores.DEXTERITY.toString(),root.getJSONObject("dexterity").getInt("score"));
        scores.addScore(dex);
        AbilityScore con = new AbilityScore(Abilityscores.CONSTITUTION.toString(),root.getJSONObject("constitution").getInt("score"));
        scores.addScore(con);
        AbilityScore inte = new AbilityScore(Abilityscores.INTELLIGENCE.toString(),root.getJSONObject("intelligence").getInt("score"));
        scores.addScore(inte);
        AbilityScore wis = new AbilityScore(Abilityscores.WISDOM.toString(),root.getJSONObject("wisdom").getInt("score"));
        scores.addScore(wis);
        AbilityScore cha = new AbilityScore(Abilityscores.CHARISMA.toString(),root.getJSONObject("charisma").getInt("score"));
        scores.addScore(cha);
        return scores;
    }

    private Skills parseSkills(JSONArray skills, AbilityScores scores, Progression progression) throws JSONException {
        Skills skill_list = new Skills();
        for (int i = 0; i < skills.length(); i++){
            JSONObject skill = skills.getJSONObject(i);
            String name = skill.getString("typeName");
            Abilityscores used_score_name = getAbilityscoreOfSkill(name);
            AbilityScore used_score = scores.getAbilityScore(used_score_name.toString());
            Proficiency proficiency = Proficiency.getProficiency(skill.getString("proficiencyName"));
            skill_list.addSkill(new Skill(name, used_score, proficiency, progression));
        }
        return skill_list;
    }

    private Abilityscores getAbilityscoreOfSkill(String skill){
        if (skill.equals("ATHLETICS")){return Abilityscores.STRRENGTH;}
        if (skill.equals("ACROBATICS") || skill.equals("SLEIGHT_OF_HAND") || skill.equals("STEALTH")){return Abilityscores.DEXTERITY;}
        if (skill.equals("ANIMAL_HANDLING") || skill.equals("INSIGHT") || skill.equals("MEDICINE") || skill.equals("PERCEPTION") || skill.equals("SURVIVAL")){return Abilityscores.WISDOM;}
        if (skill.equals("DECEPTION") || skill.equals("INTIMIDATION") || skill.equals("PERFORMANCE") || skill.equals("PERSUASION")){return Abilityscores.CHARISMA;}
        return Abilityscores.INTELLIGENCE;
    }

    private SavingThrows parseSavingThrows(JSONObject root, AbilityScores scores, Progression progression) throws JSONException {
        SavingThrows saves = new SavingThrows();
        String name = Abilityscores.STRRENGTH.toString();
        SavingThrow str = new SavingThrow(name, scores.getAbilityScore(name), root.getJSONObject("strength").getBoolean("save"), progression);
        name = Abilityscores.DEXTERITY.toString();
        SavingThrow dex = new SavingThrow(name, scores.getAbilityScore(name), root.getJSONObject("dexterity").getBoolean("save"), progression);
        name = Abilityscores.CONSTITUTION.toString();
        SavingThrow con = new SavingThrow(name, scores.getAbilityScore(name), root.getJSONObject("constitution").getBoolean("save"), progression);
        name = Abilityscores.INTELLIGENCE.toString();
        SavingThrow inte = new SavingThrow(name, scores.getAbilityScore(name), root.getJSONObject("intelligence").getBoolean("save"), progression);
        name = Abilityscores.WISDOM.toString();
        SavingThrow wis = new SavingThrow(name, scores.getAbilityScore(name), root.getJSONObject("wisdom").getBoolean("save"), progression);
        name = Abilityscores.CHARISMA.toString();
        SavingThrow cha = new SavingThrow(name, scores.getAbilityScore(name), root.getJSONObject("charisma").getBoolean("save"), progression);
        saves.addSavingThrow(str);
        saves.addSavingThrow(dex);
        saves.addSavingThrow(con);
        saves.addSavingThrow(inte);
        saves.addSavingThrow(wis);
        saves.addSavingThrow(cha);
        return saves;
    }
}
