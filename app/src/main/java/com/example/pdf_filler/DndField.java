package com.example.pdf_filler;

public enum DndField {
    CHARACTER_NAME("CharacterName"),
    CHARACTER_NAME2("CharacterName 2"),
    CLASS_LEVEL("ClassLevel"),
    PLAYER_NAME("PlayerName"),
    RACE("Race"),
    ALIGNMENT("Alignment"),
    XP("XP"),
    AGE("Age"),
    EYES("Eyes"),
    HEIGHT("Height"),
    SKIN("Skin"),
    WEIGHT("Weight"),
    HAIR("Hair"),
    STRENGTH("STR"),
    STRENGTH_MOD("STRmod"),
    DEXTERITY("DEX"),
    DEXTERITY_MOD("DEXmod "),
    CONSTITUTION("CON"),
    CONSTITUTION_MOD("CONmod"),
    INTELLIGENCE("INT"),
    INTELLIGENCE_MOD("INTmod"),
    WISODOM("WIS"),
    WISDOM_MOD("WISmod"),
    CHARISMA("CHA"),
    CHARISMA_MOD("CHamod"),
    INSPIRATION("Inspiration"),
    PROFICIENCY("ProfBonus"),
    ARMOR_CLASS("AC"),
    INITIATIVE("Initiative"),
    SPEED("Speed"),
    HP_MAX("HPMax"),
    HP_CURRENT("HPCurrent"),
    HP_TEMP("HPTemp"),
    HIT_DICE_TOTAL("HDTotal"),
    HIT_DICE("HD"),
    ST_STRENGTH_PROFICIENCY("Check Box 11"),
    ST_STRENGTH("ST Strength"),
    ST_DEXTERITY_PROFICIENCY("Check Box 18"),
    ST_DEXTERITY("ST Dexterity"),
    ST_CONSTITUTION_PROFICIENCY("Check Box 19"),
    ST_CONSTITUTION("ST Dexterity"),
    ST_INTELLIGENCE_PROFICIENCY("Check Box 20"),
    ST_INTELLIGENCE("ST Intelligence"),
    ST_WISDOM_PROFICIENCY("Check Box 21"),
    ST_WISDOM("ST Wisdom"),
    ST_CHARISMA_PROFICIENCY("Check Box 22"),
    ST_CHARISMA("ST Charisma"),
    ACROBATICS("Acrobatics"),
    ACROBATICS_CHECKBOX("Check Box 23"),
    ANIMAL_HANDLING("Animal"),
    ANIMAL_HANDLING_CHECKBOX("Check Box 24"),
    ARCANA("Arcana"),
    ARCANA_CHECKBOX("Check Box 25"),
    ATHLETICS("Athletics"),
    ATHLETICS_CHECKBOX("Check Box 26"),
    DECEPTION("Deception"),
    DECEPTION_CHECKBOX("Check Box 27"),
    HISTORY("History"),
    HISTORY_CHECKBOX("Check Box 28"),
    INSIGHT("Insight"),
    INSIGHT_CHECKBOX("Check Box 29"),
    INTIMIDATION("Intimidation"),
    INTIMIDATION_CHECKBOX("Check Box 30"),
    INVESTIGATION("Investigation"),
    INVESTIGATION_CHECKBOX("Check Box 31"),
    MEDICINE("Medicine"),
    MEDICINE_CHECKBOX("Check Box 32"),
    NATURE("Nature"),
    NATURE_CHECKBOX("Check Box 33"),
    PERCEPTION("Perception"),
    PERCEPTION_CHECKBOX("Check Box 34"),
    PERFORMANCE("Performance"),
    PERFORMANCE_CHECKBOX("Check Box 35"),
    PERSUASION("Persuasion"),
    PERSUASION_CHECKBOX("Check Box 36"),
    RELIGION("Religion"),
    RELIGION_CHECKBOX("Check Box 37"),
    SLEIGHT_OF_HAND("SleightofHand"),
    SLEIGHT_OF_HAND_CHECKBOX("Check Box 38"),
    STEALTH("Stealth"),
    STEALTH_CHECKBOX("Check Box 39"),
    SURVIVAL("Survival"),
    SURVIVAL_CHECKBOX("Check Box 40"),
    PASSIVE_PERCEPTION("Passive"),
    PROFICIENCIES_LANGUAGES("ProficienciesLang"),
    PERSONALITY("PersonalityTraits "),
    IDEALS("Ideals"),
    BONDS("Bonds"),
    FLAWS("Flaws"),
    FEATURES_TRAITS("Features and Traits"),
    ATTACK_1("Wpn Name"),
    ATTACK_1_ATK_BONUS("Wpn1 AtkBonus"),
    ATTACK_1_DMG("Wpn1 Damage"),
    ATTACK_2("Wpn Name 2"),
    ATTACK_2_ATK_BONUS("Wpn2 AtkBonus"),
    ATTACK_2_DMG("Wpn2 Damage"),
    ATTACK_3("Wpn Name 3"),
    ATTACK_3_ATK_BONUS("Wpn3 AtkBonus"),
    ATTACK_3_DMG("Wpn3 Damage"),
    ATTACKS_SPELLCASTING("AttacksSpellcasting"),
    COPPER("CP"),
    SILVER("SP"),
    ELECTRUM("EP"),
    GOLD("GP"),
    PLATIN("PP"),
    EQUIPMENT("Equipment"),
    ALLIES("Allies"),
    ORGANIZATION("FactionName"),
    BACKSTORY("Backstory"),
    ADDITIONAL_FEATURES_TRAITS("Feat+Traits"),
    TREASURE("Treasure"),

    //spellcasting page
    SPELLCASTING_CLASS("Spellcasting Class 2"),
    SPELLCASTING_ABILITY("SpellcastingAbility 2"),
    SPELL_SAVE_DC("SpellSaveDC  2"),
    SPELL_ATK_BONUS("SpellAtkBonus 2"),

    //cantrips
    CANTRIP_1("Spells 1014"),
    CANTRIP_2("Spells 1016"),
    CANTRIP_3("Spells 1017"),
    CANTRIP_4("Spells 1018"),
    CANTRIP_5("Spells 1019"),
    CANTRIP_6("Spells 1020"),
    CANTRIP_7("Spells 1021"),
    CANTRIP_8("Spells 1022"),

    //lvl1 Spells
    LVL1_SLOTS("SlotsTotal 19"),
    LVL1_1("Spells 1015"),
    LVL1_2("Spells 1023"),
    LVL1_3("Spells 1024"),
    LVL1_4("Spells 1025"),
    LVL1_5("Spells 1026"),
    LVL1_6("Spells 1027"),
;
    private final String field;

    DndField(final String field){
        this.field = field;
    }

    @Override
    public String toString(){
        return field;
    }
}
