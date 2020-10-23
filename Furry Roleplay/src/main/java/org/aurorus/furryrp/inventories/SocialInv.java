package org.aurorus.furryrp.inventories;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import skinsrestorer.bukkit.SkinsRestorer;
import skinsrestorer.bukkit.SkinsRestorerBukkitAPI;
import skinsrestorer.shared.utils.ReflectionUtil;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

public class SocialInv
{

    private final Main plugin;

    public SocialInv(Main plugin){
        this.plugin = plugin;
    }

    private ItemStack createPlayersProfile(Player p)
    {
        ArrayList<Sona> sonasList = Sona.SonasList;
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        meta.setPlayerProfile(p.getPlayerProfile());
        meta.setDisplayName(ChatColor.WHITE + p.getDisplayName());
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

    private ItemStack placeholder()
    {
        ItemStack item = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Use /setsona to set informations about your sona");
        item.setItemMeta(meta);

        return item;
    }

    public void openInv(Player p)
    {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Paw Portal");
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        ArrayList<? extends Player> playersList = new ArrayList(players);
        Random random = new Random();
        if (players.size() > 45)
            for (int i = 0; i<45; i++)
            {
                inv.addItem(createPlayersProfile(playersList.get(random.nextInt(players.size()))));
            }
        else
        {
            for (Player p2 : players)
                inv.addItem(createPlayersProfile(p2));
        }

        for (int i = 45; i<54; i++)
            inv.setItem(i, placeholder());

        p.openInventory(inv);
    }
}
