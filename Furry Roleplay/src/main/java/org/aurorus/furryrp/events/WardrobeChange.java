package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import skinsrestorer.bukkit.SkinsRestorer;
import skinsrestorer.bukkit.SkinsRestorerBukkitAPI;
import skinsrestorer.shared.exception.SkinRequestException;

import java.util.ArrayList;

public class WardrobeChange implements Listener
{

    private final Main plugin;

    public WardrobeChange(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();
        ItemStack item = e.getCurrentItem();
        SkinsRestorer skinsRestorer = JavaPlugin.getPlugin(SkinsRestorer.class);
        SkinsRestorerBukkitAPI skinsRestorerBukkitAPI = skinsRestorer.getSkinsRestorerBukkitAPI();

        if (item == null)
            return;

        if (invName.equals(ChatColor.GREEN + "Wardrobe"))
        {
            e.setCancelled(true);
            if (item.getItemMeta().hasDisplayName())
            {
                if (!(item.getType().equals(Material.LIME_STAINED_GLASS_PANE)))
                {
                    try
                    {
                        skinsRestorerBukkitAPI.setSkin(p.getName(), item.getItemMeta().getDisplayName());
                        skinsRestorerBukkitAPI.applySkin(p);
                    }
                    catch (SkinRequestException err)
                    {
                        System.out.print(err);
                    }
                }
            }

            if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Generate Skin File"))
            {
                p.sendMessage(ChatColor.GREEN + "https://aurorusfur.github.io/SkinFile-Generator/index.html?" + p.getUniqueId());
            }
        }
    }
}
