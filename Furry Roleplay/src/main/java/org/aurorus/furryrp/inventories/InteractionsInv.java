package org.aurorus.furryrp.inventories;

import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class InteractionsInv {
    Utils utils = new Utils();

    ItemStack createHead(Player p) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        meta.setPlayerProfile(p.getPlayerProfile());
        meta.setDisplayName(ChatColor.WHITE + p.getDisplayName());
        Sona s = utils.searchPlayerSona(p);

        lore.add(ChatColor.BLUE + "Name: " + s.name);
        lore.add(ChatColor.BLUE + "Height: " + s.height);
        lore.add(ChatColor.BLUE + "Age: " + s.age);
        lore.add(ChatColor.BLUE + "Sex: " + s.sex);
        lore.add(ChatColor.BLUE + "Orientation: " + s.orientation);
        lore.add(ChatColor.BLUE + "Species: " + s.species);
        lore.add(ChatColor.GREEN + "Mood: " + s.mood);
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    ItemStack createItem(String name, Material material){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }

    public void openInv(Player p, Player p2){
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Interact");

        //head
        inv.setItem(4, createHead(p2));
        inv.setItem(5, createItem(ChatColor.WHITE + "Set info about your sona using /setsona", Material.BLUE_STAINED_GLASS_PANE));
        inv.setItem(3, createItem(ChatColor.WHITE + "Set info about your sona using /setsona", Material.BLUE_STAINED_GLASS_PANE));

        //positive
        String[] positiveArray = {"Hug","Kiss","Pet","Belly Rubs","Lick","Scratch","Bite","Blep","Ear Rubs","Murr","Wags Tail","Boop"};
        for (int i = 0; i<positiveArray.length; i++){
            ItemStack item = new ItemStack(Material.LIME_WOOL);
            ItemMeta metaItem = item.getItemMeta();
            metaItem.setDisplayName(ChatColor.GREEN + positiveArray[i]);
            item.setItemMeta(metaItem);
            inv.setItem(i+9, item);
        }

        //negative
        String[] negativeArray = {"Slap","Wrrr","Spank"};
        for (int i = 0; i<negativeArray.length; i++){
            ItemStack item = new ItemStack(Material.RED_WOOL);
            ItemMeta metaItem = item.getItemMeta();
            metaItem.setDisplayName(ChatColor.RED + negativeArray[i]);
            item.setItemMeta(metaItem);
            inv.setItem(i+positiveArray.length+9, item);
        }

        p.openInventory(inv);
    }
}
