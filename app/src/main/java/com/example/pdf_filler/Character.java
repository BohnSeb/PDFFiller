package com.example.pdf_filler;

public class Character {
    //ability scores
    private final int str;
    private final int dex;
    private final int con;
    private final int intel;
    private final int wis;
    private final int cha;

    //saving throws
    private final int str_st;
    private final int dex_st;
    private final int con_st;
    private final int int_st;
    private final int wis_st;
    private final int cha_st;
    //saving throw proficiency
    private final boolean[] st_proficiencies;

    //skills
    private final String acrobatics;
    private final String animal_handling;
    private final String arcana;
    private final String athletics;
    private final String deception;
    private final String history;
    private final String insight;
    private final String intimidation;
    private final String investigation;
    private final String medicine;
    private final String nature;
    private final String perception;
    private final String performance;
    private final String persuasion;
    private final String religion;
    private final String sleight_of_hand;
    private final String stealth;
    private final String survival;
    //skill proficiencies
    private final int[] skill_proficiencies;

    //main fields
    private final String inspiration;
    private final String proficiency;
    private final String ac;
    private final String initiative;
    private final String speed;
    private final String max_hp;
    private final String hp;
    private final String tmp_hp;
    private final String hd_total;
    private final String hd;
    private final String[] class_levels;
    private final String race;
    private final String background;
    private final String alignment;
    private final String player_name;
    private final String character_name;
    private final String xp;
    private final String passive_wisdom;

    private Character(Builder build){
        //set playername, charactername, race, class, background, alignment and xp
        this.character_name = build.character_name;
        this.player_name = build.player_name;
        this.race = build.race;
        this.class_levels = build.class_level;
        this.background = build.background;
        this.alignment = build.alignment;
        this.xp = Integer.toString(build.xp);
        this.proficiency = "+"+build.prof_bonus;

        //set ability scores
        this.str = build.str;
        this.dex = build.dex;
        this.con = build.con;
        this.intel = build.intel;
        this.wis = build.wis;
        this.cha = build.cha;

        //set st proficiency and bonuses
        this.st_proficiencies = build.savingthrows;
        if (this.st_proficiencies[0]){this.str_st = build.prof_bonus + getModOfScore(this.str);} else {this.str_st = getModOfScore(this.str);} //str
        if (this.st_proficiencies[1]){this.dex_st = build.prof_bonus + getModOfScore(this.dex);} else {this.dex_st = getModOfScore(this.dex);} //dex
        if (this.st_proficiencies[2]){this.con_st = build.prof_bonus + getModOfScore(this.con);} else {this.con_st = getModOfScore(this.con);} //con
        if (this.st_proficiencies[3]){this.int_st = build.prof_bonus + getModOfScore(this.intel);} else {this.int_st = getModOfScore(this.intel);} //int
        if (this.st_proficiencies[4]){this.wis_st = build.prof_bonus + getModOfScore(this.wis);} else {this.wis_st = getModOfScore(this.wis);} //wis
        if (this.st_proficiencies[5]){this.cha_st = build.prof_bonus + getModOfScore(this.cha);} else {this.cha_st = getModOfScore(this.cha);} //cha

        //set skill proficiency and bonuses
        this.skill_proficiencies = build.skills;
        this.acrobatics = Integer.toString(getSkillMod(this.dex, this.skill_proficiencies[0],build.prof_bonus));
        this.animal_handling = Integer.toString(getSkillMod(this.wis, this.skill_proficiencies[1],build.prof_bonus));
        this.arcana = Integer.toString(getSkillMod(this.intel, this.skill_proficiencies[2],build.prof_bonus));
        this.athletics = Integer.toString(getSkillMod(this.str, this.skill_proficiencies[3],build.prof_bonus));
        this.deception = Integer.toString(getSkillMod(this.cha, this.skill_proficiencies[4],build.prof_bonus));
        this.history = Integer.toString(getSkillMod(this.intel, this.skill_proficiencies[5],build.prof_bonus));
        this.insight = Integer.toString(getSkillMod(this.wis, this.skill_proficiencies[6],build.prof_bonus));
        this.intimidation = Integer.toString(getSkillMod(this.cha, this.skill_proficiencies[7],build.prof_bonus));
        this.investigation = Integer.toString(getSkillMod(this.intel, this.skill_proficiencies[8],build.prof_bonus));
        this.medicine = Integer.toString(getSkillMod(this.wis, this.skill_proficiencies[9],build.prof_bonus));
        this.nature = Integer.toString(getSkillMod(this.intel, this.skill_proficiencies[10],build.prof_bonus));
        this.perception = Integer.toString(getSkillMod(this.wis, this.skill_proficiencies[11],build.prof_bonus));
        this.performance = Integer.toString(getSkillMod(this.cha, this.skill_proficiencies[12],build.prof_bonus));
        this.persuasion = Integer.toString(getSkillMod(this.cha, this.skill_proficiencies[13],build.prof_bonus));
        this.religion = Integer.toString(getSkillMod(this.intel, this.skill_proficiencies[14],build.prof_bonus));
        this.sleight_of_hand = Integer.toString(getSkillMod(this.dex, this.skill_proficiencies[15],build.prof_bonus));
        this.stealth = Integer.toString(getSkillMod(this.dex, this.skill_proficiencies[16],build.prof_bonus));
        this.survival = Integer.toString(getSkillMod(this.wis, this.skill_proficiencies[17],build.prof_bonus));

        this.inspiration = build.inspiration;
        this.ac = Integer.toString(10 + getModOfScore(build.dex));
        if (this.getModOfScore(this.dex) >= 0){this.initiative = "+" + this.getModOfScore(this.dex);}else{this.initiative = "-" + this.getModOfScore(this.dex);}
        this.speed = Integer.toString(build.speed);
        this.max_hp = Integer.toString(build.max_hp);
        this.hp = Integer.toString(build.hp);
        this.tmp_hp = Integer.toString(build.tmp_hp);
        this.hd_total = build.hd_total;
        this.hd = build.hd_current;

        this.passive_wisdom = Integer.toString(10 + Integer.valueOf(this.perception));
    }

    private int getSkillMod(int mod, int prof_mode, int proficiency){ //mod 0 = none, 1 = jack of all trades, 2 = proficient, 3 = expert
        int l_mod = 0;
        switch (prof_mode){
            case 0 : l_mod = mod;break;
            case 1 : l_mod = (int) mod + (proficiency/2);break;
            case 2 : l_mod = mod + proficiency;break;
            case 3 : l_mod = mod + (proficiency*2);break;
        }
        return l_mod;
    }

    private int getModOfScore(int score){
        double l_calcBeforeRound = (score-10)/2;
        int l_mod = 0;
        if (l_calcBeforeRound >= 0){
            l_mod = (int) Math.floor(l_calcBeforeRound);
        } else {
            l_mod = (int) Math.ceil(l_calcBeforeRound);
        }
        return l_mod;
    }

    public class Builder {
        public String inspiration = "";
        //ability scores
        private int str = 10;
        private int dex = 10;
        private int con = 10;
        private int intel = 10;
        private int wis = 10;
        private int cha = 10;

        private int prof_bonus = 2;

        //saving throws proficiency, true = proficient
        private boolean[] savingthrows = new boolean[6];

        //skill proficiencies, 0 = not proficient, 1 = jack of all trades, 2 = proficient, 3 = expert
        private int[] skills = new int[18];

        //important fields, that will be otherwise set automatically
        private String player_name = "";
        private int AC = 10;
        private int initiative = 0;
        private int speed = 30;
        private int max_hp;
        private int hp;
        private int tmp_hp;
        private String hd_total;
        private String hd_current;
        private String[] class_level;
        private String background;
        private String alignment;
        private String character_name;
        private int xp;
        private boolean joat;
        private String race;


        //savingthrow and ability score setter
        public Builder setStr(int str, boolean st){
            this.str = str;
            this.savingthrows[0] = st;
            return this;
        }
        public Builder setDex(int dex, boolean st){
            this.dex = dex;
            this.savingthrows[1] = st;
            return this;
        }
        public Builder setCon(int con, boolean st){
            this.con = con;
            this.savingthrows[2] = st;
            return this;
        }
        public Builder setInt(int intel, boolean st){
            this.intel = intel;
            this.savingthrows[3] = st;
            return this;
        }
        public Builder setWis(int wis, boolean st){
            this.wis = wis;
            this.savingthrows[4] = st;
            return this;
        }
        public Builder setCha(int cha, boolean st){
            this.cha = cha;
            this.savingthrows[5] = st;
            return this;
        }

        //proficiency setter
        public Builder setProficiencyBonus(int prof){
            this.prof_bonus = prof;
            return this;
        }
        public Builder setProficiency(int skill, String proficiency){
            int l_proficiency = 0;
            switch(proficiency){
                case "NONE" : l_proficiency = 0; break;
                case "FULL" : l_proficiency = 2; break;
                case "EXPERT" : l_proficiency = 3; break;
            }
            if (joat && l_proficiency == 0){l_proficiency = 1;}
            skills[skill] = l_proficiency;
            return this;
        }

        public Character build(){
            return new Character(this);
        }
    }
}
