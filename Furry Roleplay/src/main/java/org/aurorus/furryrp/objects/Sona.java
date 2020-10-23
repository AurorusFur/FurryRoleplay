package org.aurorus.furryrp.objects;

import java.util.ArrayList;
import java.util.UUID;

public class Sona {
    public static ArrayList<Sona> SonasList = new ArrayList<>();

    public String age;
    public String species;
    public String orientation;
    public String sex;
    public String name;
    public String mood;
    public String height;
    public UUID id;
    public int coins;
    public int daily;
    public Quest quest;
    public int finishedQuests;
    public int skippedQuests;
    public int streakQuests;

    public Sona(){

    }

    public Sona(String age, String species, String orientation, String sex, String name, String mood, String height, int coins, UUID id, int daily, Quest quest, int finishedQuests, int skippedQuests, int streakQuests){
        this.age = age;
        this.species = species;
        this.orientation = orientation;
        this.sex = sex;
        this.name = name;
        this.mood = mood;
        this.coins = coins;
        this.height = height;
        this.id = id;
        this.daily = daily;
        this.quest = quest;
        this.finishedQuests = finishedQuests;
        this.skippedQuests = skippedQuests;
        this.streakQuests = streakQuests;
    }
}
