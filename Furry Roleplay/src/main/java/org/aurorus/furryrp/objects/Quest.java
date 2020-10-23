package org.aurorus.furryrp.objects;

import org.bukkit.Material;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Quest {
    public String name;
    public int reward;
    public Material icon;
    public static ArrayList<Quest> quests = new ArrayList<>();
    public ArrayList<QuestItem> items = new ArrayList<>();

    public void createQuests(){
        quests.add(new Quest("Go Fishing!", new ArrayList<QuestItem>(){{add(new QuestItem(32, Material.COD, false));add(new QuestItem(16, Material.SALMON, false));add(new QuestItem(1, Material.PUFFERFISH, false));}}, 30, Material.COD_BUCKET));
        quests.add(new Quest("Woolie", new ArrayList<QuestItem>(){{add(new QuestItem(32, Material.WHITE_WOOL, false));}}, 10, Material.WHITE_WOOL));
        quests.add(new Quest("Timberman", new ArrayList<QuestItem>(){{add(new QuestItem(64, Material.OAK_LOG, false));}}, 20, Material.IRON_AXE));
        quests.add(new Quest("Jeweler", new ArrayList<QuestItem>(){{add(new QuestItem(3, Material.DIAMOND, false));add(new QuestItem(5, Material.EMERALD, false));}}, 160, Material.DIAMOND));
        quests.add(new Quest("Intense Rainbow Dye", new ArrayList<QuestItem>(){{add(new QuestItem(2, Material.LIME_DYE, false));add(new QuestItem(2, Material.YELLOW_DYE, false));add(new QuestItem(2, Material.ORANGE_DYE, false));add(new QuestItem(2, Material.LIGHT_BLUE_DYE, false));add(new QuestItem(2, Material.CYAN_DYE, false));add(new QuestItem(2, Material.BLUE_DYE, false));add(new QuestItem(2, Material.PINK_DYE, false));add(new QuestItem(2, Material.PURPLE_DYE, false));add(new QuestItem(2, Material.MAGENTA_DYE, false));}}, 80, Material.WHITE_DYE));
        quests.add(new Quest("Birthday Cake", new ArrayList<QuestItem>(){{add(new QuestItem(1, Material.CAKE, false));}}, 40, Material.CAKE));
        quests.add(new Quest("Shiny Stones", new ArrayList<QuestItem>(){{add(new QuestItem(8, Material.GOLD_ORE, false));}}, 10, Material.GOLD_ORE));
        quests.add(new Quest("Hell Lights", new ArrayList<QuestItem>(){{add(new QuestItem(16, Material.GLOWSTONE, false));}}, 40, Material.LAVA_BUCKET));
        quests.add(new Quest("Explosive Powder", new ArrayList<QuestItem>(){{add(new QuestItem(64, Material.GUNPOWDER, false));}}, 20, Material.GUNPOWDER));
        quests.add(new Quest("Delicious Dinner", new ArrayList<QuestItem>(){{add(new QuestItem(1, Material.COOKED_PORKCHOP, false));add(new QuestItem(3, Material.BAKED_POTATO, false));add(new QuestItem(3, Material.BEETROOT, false));}}, 20, Material.COOKED_PORKCHOP));
        quests.add(new Quest("Underwater Snack", new ArrayList<QuestItem>(){{add(new QuestItem(64, Material.DRIED_KELP, false));}}, 30, Material.DRIED_KELP));
        quests.add(new Quest("Keep it alive", new ArrayList<QuestItem>(){{add(new QuestItem(1, Material.TROPICAL_FISH_BUCKET, false));}}, 20, Material.TROPICAL_FISH_BUCKET));
    }

    public Quest pickQuest(){
        int RInt = new Random().nextInt(quests.size());
        Quest quest = new Quest(quests.get(RInt).name, new ArrayList<QuestItem>(){{for (QuestItem q : quests.get(RInt).items){{add(new QuestItem(q.needed, q.item, false));}}}}, quests.get(RInt).reward, quests.get(RInt).icon);

        return quest;
    }

    public Quest(){

    }

    public Quest(String name, ArrayList<QuestItem> items, int reward, Material icon){
        this.name = name;
        this.items = items;
        this.reward = reward;
        this.icon = icon;
    }
}
