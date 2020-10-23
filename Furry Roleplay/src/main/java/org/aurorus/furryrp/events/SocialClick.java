package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SocialClick implements Listener
{

    private final Main plugin;

    public SocialClick(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();
        ItemStack item = e.getCurrentItem();

        if (item == null)
            return;

        if (invName.contains(ChatColor.GREEN + "Paw Portal"))
        {
            e.setCancelled(true);
        }
    }
}
