package org.aurorus.furryrp.inventories;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Quest;
import org.aurorus.furryrp.objects.QuestItem;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class QuestInv {
    private final Main plugin;

    public QuestInv(Main plugin){
        this.plugin = plugin;
    }

    ItemStack createItem(Material material, int amount, String name, ChatColor color, String[] lore){
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color + name);
        ArrayList<String> lore2 = new ArrayList<>();
        if (lore != null){
            for (String s : lore)
                lore2.add(s);
            meta.setLore(lore2);
        }
        item.setItemMeta(meta);

        return item;
    }

    ItemStack streak(Player p){

        Material material = null;
        int streak = 0;

        for (Sona s : Sona.SonasList)
            if (s.id.equals(p.getUniqueId())){
                streak = s.streakQuests;
                if (s.streakQuests == 0)
                    material = Material.WHITE_STAINED_GLASS_PANE;
                else if (s.streakQuests > 0 && s.streakQuests <= 25)
                    material = Material.YELLOW_STAINED_GLASS_PANE;
                else if (s.streakQuests > 25 && s.streakQuests <= 50)
                    material = Material.ORANGE_STAINED_GLASS_PANE;
                else if (s.streakQuests > 50 && s.streakQuests <= 75)
                    material = Material.RED_STAINED_GLASS_PANE;
                else if (s.streakQuests > 75 && s.streakQuests < 100)
                    material = Material.BLUE_STAINED_GLASS_PANE;
                else
                    material = Material.BLACK_STAINED_GLASS_PANE;
            }

        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Your Streak: " + streak);
        item.setItemMeta(meta);

        return item;
    }

    public void skipQuest(Player p){
        for (Sona s : Sona.SonasList)
            if (s.id.equals(p.getUniqueId())){
                s.streakQuests = 0;
                s.skippedQuests++;
                s.quest = new Quest().pickQuest();
            }
    }

    public void openInv(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Current Order");
        Quest selected = null;
        ArrayList<QuestItem> items = null;
        int finishedQuests = 0;
        int skippedQuests = 0;
        boolean complete = true;

        for (Sona s : Sona.SonasList){
            if (s.id.equals(p.getUniqueId())){
                if (s.quest == null){
                    s.quest = new Quest().pickQuest();
                }
                selected = s.quest;
                finishedQuests = s.finishedQuests;
                skippedQuests = s.skippedQuests;
                items = s.quest.items;

                for (QuestItem q : items){
                    if (!q.isCompleted)
                        complete = false;
                }
                if (complete){
                    s.finishedQuests++;
                    p.sendMessage(ChatColor.GREEN + "-----------------------------");
                    p.sendMessage(ChatColor.GREEN + "+" + s.quest.reward + " " + plugin.coinsName + " / +" + s.streakQuests + " Streak");
                    p.sendMessage(ChatColor.GREEN + "-----------------------------");
                    s.coins += s.quest.reward;
                    s.coins += s.streakQuests;
                    s.streakQuests++;
                    s.quest = new Quest().pickQuest();
                    selected = s.quest;
                    finishedQuests = s.finishedQuests;
                    skippedQuests = s.skippedQuests;
                    items = s.quest.items;

                    if (s.streakQuests >= 100){
                        p.sendMessage(ChatColor.GRAY + "Streak Burned!");
                        p.sendMessage(ChatColor.BLUE + "+25 Bonus " + plugin.coinsName);
                        s.coins += 25;
                        s.streakQuests = 0;
                    }
                }
            }
        }

        ItemStack item = new ItemStack(selected.icon);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        meta.setDisplayName(ChatColor.BLUE + selected.name);

        for (QuestItem q : items){
            if (!q.isCompleted)
                lore.add(ChatColor.RED + q.item.name() + " " + "x" + q.needed);
            if (q.isCompleted)
                lore.add(ChatColor.GREEN + q.item.name() + " " + "x" + q.needed);
        }

        lore.add(ChatColor.GREEN + "Reward in " + plugin.coinsName + ":");
        lore.add(ChatColor.GREEN + ""+selected.reward);
        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(4, item);
        inv.setItem(8, createItem(Material.RED_CONCRETE, 1, "Skipped Orders", ChatColor.RED, new String[]{ChatColor.WHITE+""+skippedQuests}));
        inv.setItem(6, createItem(Material.GREEN_CONCRETE, 1, "Finished Orders", ChatColor.GREEN, new String[]{ChatColor.WHITE+""+finishedQuests}));
        inv.setItem(7, streak(p));
        inv.setItem(0, createItem(Material.RED_STAINED_GLASS_PANE, 1, "Skip Order", ChatColor.RED, null));

        p.openInventory(inv);
    }
}
