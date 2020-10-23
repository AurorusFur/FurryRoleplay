package org.aurorus.furryrp.objects;

import org.bukkit.Material;

import java.util.ArrayList;

public class QuestItem {
    public int needed;
    public Material item;
    public boolean isCompleted;

    public QuestItem(){

    }

    public QuestItem(int needed, Material item, boolean isCompleted){
        this.needed = needed;
        this.item = item;
        this.isCompleted = isCompleted;
    }
}
