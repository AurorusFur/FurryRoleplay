package org.aurorus.furryrp.inventories.setsona;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class SetSonaInv {
    private final Main plugin;

    public SetSonaInv(Main plugin){
        this.plugin = plugin;
    }

    ItemStack createItem(String name, Material material){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + name);
        item.setItemMeta(meta);

        return item;
    }

    ItemStack createHead(Player p) {
        ArrayList<Sona> sonasList = Sona.SonasList;
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        meta.setPlayerProfile(p.getPlayerProfile());
        meta.setDisplayName(ChatColor.WHITE + "Your Sona");
        for (Sona s : sonasList)
        {
            if (p.getUniqueId().equals(s.id))
            {
                lore.add(ChatColor.BLUE + "Name: " + s.name);
                lore.add(ChatColor.BLUE + "Height: " + s.height);
                lore.add(ChatColor.BLUE + "Age: " + s.age);
                lore.add(ChatColor.BLUE + "Sex: " + s.sex);
                lore.add(ChatColor.BLUE + "Orientation: " + s.orientation);
                lore.add(ChatColor.BLUE + "Species: " + s.species);
                lore.add(ChatColor.GREEN + "Mood: " + s.mood);
            }
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public void openInv(Player p, String invName){
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Setup Sona Info");

        inv.setItem(0, createItem("Name", Material.PAPER));
        inv.setItem(1, createItem("Height", Material.PAPER));
        inv.setItem(2, createItem("Age", Material.PAPER));
        inv.setItem(3, createItem("Sex", Material.PAPER));
        inv.setItem(4, createItem("Orientation", Material.PAPER));
        inv.setItem(5, createItem("Species", Material.PAPER));
        inv.setItem(6, createItem("Mood", Material.PAPER));
        inv.setItem(8, createHead(p));

        if (invName == null){
            p.openInventory(inv);
        }
        else if (invName.contains("Name")){
            new SignInput(plugin).openSignInputName(p);
        }
        else if (invName.contains("Age")){
            new SetSonaAgeInv(plugin).openInv(p, 0);
        }
        else if (invName.contains("Orientation")){
            new SignInput(plugin).openSignInputOrientation(p);
        }
        else if (invName.contains("Sex")){
            new SetSonaSexInv(plugin).openInv(p);
        }
        else if (invName.contains("Species")){
            new SetSonaSpeciesInv(plugin).openInv(p);
        }
        else if (invName.contains("Height")){
            new SetSonaHeightInv(plugin).openInv(p, 0, "cm");
        }
        else if (invName.contains("Mood")){
            new SignInput(plugin).openSignInputMood(p);
        }
    }
}
