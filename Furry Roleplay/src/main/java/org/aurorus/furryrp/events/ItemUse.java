package org.aurorus.furryrp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemUse implements Listener
{
    @EventHandler
    public void onUse(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();

        if (item == null)
        {
            return;
        }

        if (item.getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Squeaky Toy") && (action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)))
        {
            Bukkit.getWorld(p.getWorld().getName()).playSound(p.getLocation(), Sound.ENTITY_BAT_AMBIENT, 1f, 1f);
        }
    }
}
