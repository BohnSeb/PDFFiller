package com.example.pdf_filler;

import android.content.Context;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DndPdf {
    public static final int NEW_FILE_REQUEST_CODE = 1;
    private File m_workingFile;
    private File m_cachedSourceFile;
    private PdfDocument m_pdfDocument;
    private File m_assetFile;
    private Context m_context;
    private PdfAcroForm m_form;

    public DndPdf(Context context) {
        //save ActivityContext
        this.m_context = context;
        //load asset pdf file
        this.m_assetFile = new File(m_context.getCacheDir()+File.separator+"DD.pdf");

        //cache the asset file
        try {
            this.m_cachedSourceFile = cacheFile(new FileInputStream(this.m_assetFile), "DD-cached.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //create working file in cache
        this.m_workingFile = new File(m_context.getCacheDir()+"workingfile.pdf");

        //create PdfDocument object to write to m_workingFile
        try {
            this.m_pdfDocument = new PdfDocument(new PdfReader(this.m_cachedSourceFile), new PdfWriter(this.m_workingFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //open forms
        m_form = PdfAcroForm.getAcroForm(m_pdfDocument,true);
    }

    private void setField (DndField f, String value){
        m_form.getField(f.toString()).setValue(value);
    }

    public DndPdf setCharacterName(String characterName){
        this.setField(DndField.CHARACTER_NAME, characterName);
        this.setField(DndField.CHARACTER_NAME2, characterName);
        return this;
    }

    private void setAbilityScore(DndField score, DndField mod, int value){
        this.setField(score, Integer.toString(value));
        double l_calcBeforeRound = (value-10)/2;
        if (l_calcBeforeRound >= 0){
            this.setField(mod, Integer.toString((int) Math.floor(l_calcBeforeRound)));
        } else {
            this.setField(mod, Integer.toString((int) Math.ceil(l_calcBeforeRound)));
        }
    }

    public DndPdf setStr(int str){
        setAbilityScore(DndField.STRENGTH, DndField.STRENGTH_MOD, str);
        return this;
    }

    public DndPdf setDex(int dex){
        setAbilityScore(DndField.DEXTERITY, DndField.DEXTERITY_MOD, dex);
        return this;
    }

    public DndPdf setCon(int con){
        setAbilityScore(DndField.CONSTITUTION, DndField.CONSTITUTION_MOD, con);
        return this;
    }

    public DndPdf setInt(int i){
        setAbilityScore(DndField.INTELLIGENCE, DndField.INTELLIGENCE_MOD, i);
        return this;
    }

    public DndPdf setWis(int wis){
        setAbilityScore(DndField.WISODOM, DndField.WISDOM_MOD, wis);
        return this;
    }

    public DndPdf setCha(int cha){
        setAbilityScore(DndField.CHARISMA, DndField.CHARISMA_MOD, cha);
        return this;
    }

    public DndPdf setClassLevel(String classlevel){
        this.setField(DndField.CLASS_LEVEL, classlevel);
        return this;
    }

    public DndPdf setClassLevel(String[] classlevels){
        String l_classLevelsString = "";
        for (int i = 0; i < classlevels.length; i++){
            l_classLevelsString = l_classLevelsString + classlevels[i] + System.lineSeparator();
        }
        this.setClassLevel(l_classLevelsString);
        return this;
    }

    public DndPdf setArmorClass(int ac){
        this.setField(DndField.ARMOR_CLASS, Integer.toString(ac));
        return this;
    }

    public DndPdf setArmorClass(String ac){
        this.setField(DndField.ARMOR_CLASS, ac);
        return this;
    }

    public DndPdf setPlayerName(String pn){
        this.setField(DndField.PLAYER_NAME, pn);
        return this;
    }

    public DndPdf setRace(String race){
        this.setField(DndField.RACE, race);
        return this;
    }

    public DndPdf setAlignment(String alignment){
        this.setField(DndField.ALIGNMENT, alignment);
        return this;
    }

    public DndPdf setExperiencePoints(String xp){
        this.setField(DndField.XP, xp);
        return this;
    }

    public DndPdf setExperiencePoints(int xp){
        this.setExperiencePoints(Integer.toString(xp));
        return this;
    }

    public DndPdf setProficiencyBonus(String proficiency){
        this.setField(DndField.PROFICIENCY, proficiency);
        return this;
    }

    public DndPdf setProficiencyBonus(int proficiency){
        this.setProficiencyBonus("+"+proficiency);
        return this;
    }

    public DndPdf setInitiative(String initiative){
        this.setField(DndField.INITIATIVE, initiative);
        return this;
    }

    public DndPdf setInitiative(int initiative){
        this.setProficiencyBonus("+"+initiative);
        return this;
    }

    public DndPdf setInspiration(String inspiration){
        this.setField(DndField.INSPIRATION, inspiration);
        return this;
    }

    public DndPdf setInspiration(int inspiration){
        this.setInspiration(Integer.toString(inspiration));
        return this;
    }

    public DndPdf setSpeed(String speed){
        this.setField(DndField.SPEED, speed);
        return this;
    }

    public DndPdf setSpeed(int speed){
        this.setSpeed(Integer.toString(speed));
        return this;
    }

    public DndPdf setHP(String hp){
        this.setField(DndField.HP_CURRENT, hp);
        return this;
    }

    public DndPdf setHP(int hp){
        this.setSpeed(Integer.toString(hp));
        return this;
    }

    public DndPdf setMaxHP(String hp){
        this.setField(DndField.HP_MAX, hp);
        return this;
    }

    public DndPdf setMaxHP(int hp){
        this.setSpeed(Integer.toString(hp));
        return this;
    }

    public DndPdf setTempHP(String hp){
        this.setField(DndField.HP_TEMP, hp);
        return this;
    }

    public DndPdf setTempHP(int hp){
        this.setSpeed(Integer.toString(hp));
        return this;
    }

    public DndPdf setHitDiceTotal(String hd_total){
        this.setField(DndField.HIT_DICE_TOTAL, hd_total);
        return this;
    }

    public DndPdf setHitDice(String hd){
        this.setField(DndField.HIT_DICE, hd);
        return this;
    }

    private void setSavingThrow(DndField field,DndField checkbox, String value, boolean proficient){
        this.setField(field, value);
        this.setCheckbox(checkbox, proficient);
    }

    public DndPdf setSTStrength(String value, boolean proficient){
        this.setSavingThrow(DndField.ST_STRENGTH, DndField.ST_STRENGTH_PROFICIENCY, value, proficient);
        return this;
    }
    public DndPdf setSTStrength(int value, boolean proficient){
        this.setSTStrength(Integer.toString(value), proficient);
        return this;
    }

    public DndPdf setSTDexterity(String value, boolean proficient){
        this.setSavingThrow(DndField.ST_DEXTERITY, DndField.ST_DEXTERITY_PROFICIENCY, value, proficient);
        return this;
    }
    public DndPdf setSTDexterity(int value, boolean proficient){
        this.setSTStrength(Integer.toString(value), proficient);
        return this;
    }

    public DndPdf setSTConstitution(String value, boolean proficient){
        this.setSavingThrow(DndField.ST_CONSTITUTION, DndField.ST_CONSTITUTION_PROFICIENCY, value, proficient);
        return this;
    }
    public DndPdf setSTConstitution(int value, boolean proficient){
        this.setSTStrength(Integer.toString(value), proficient);
        return this;
    }

    public DndPdf setSTIntelligence(String value, boolean proficient){
        this.setSavingThrow(DndField.ST_INTELLIGENCE, DndField.ST_INTELLIGENCE_PROFICIENCY, value, proficient);
        return this;
    }
    public DndPdf setSTIntelligence(int value, boolean proficient){
        this.setSTStrength(Integer.toString(value), proficient);
        return this;
    }

    public DndPdf setSTWisdom(String value, boolean proficient){
        this.setSavingThrow(DndField.ST_WISDOM, DndField.ST_WISDOM_PROFICIENCY, value, proficient);
        return this;
    }
    public DndPdf setSTWisdom(int value, boolean proficient){
        this.setSTStrength(Integer.toString(value), proficient);
        return this;
    }

    public DndPdf setSTCharisma(String value, boolean proficient){
        this.setSavingThrow(DndField.ST_CHARISMA, DndField.ST_CHARISMA_PROFICIENCY, value, proficient);
        return this;
    }
    public DndPdf setSTCharisma(int value, boolean proficient){
        this.setSTStrength(Integer.toString(value), proficient);
        return this;
    }

    private void setSkill(DndField field, String bonus, DndField checkbox, boolean proficient){
        this.setCheckbox(checkbox, proficient);
        this.setField(field, bonus);
    }

    public DndPdf setAcrobatics(){
        this.setSkill(DndField.);
        return this;
    }

    public void setCheckbox(DndField field, boolean value){
        if (value){
            this.setField(field, "Yes");
        } else{
            this.setField(field, "Off");
        }
    }

    public File saveFile() {
        this.m_pdfDocument.close();
        return this.m_workingFile;
    }

    private boolean copyFile(InputStream input, File to) {
        if (to.exists()){
            to.delete();
        }
        try (FileOutputStream l_fileOutputStream = new FileOutputStream(to, false)){
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            l_fileOutputStream.write(buffer);
            l_fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return false;
    }

    private File cacheFile(InputStream input, String outputFileName){
        File l_cachedFile = new File(m_context.getCacheDir()+File.separator+outputFileName);
        if (copyFile(input, l_cachedFile)){
            return l_cachedFile;
        }
        return new File("");
    }
}
