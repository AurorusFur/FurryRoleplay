package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.objects.SelectedEntity;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BuyPrideItem implements Listener
{

    private final Main plugin;

    public BuyPrideItem(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();
        ItemStack item = e.getCurrentItem();
        String coinsName = plugin.coinsName;
        Utils utils = new Utils();

        if (item == null)
            return;

        if (invName.equals(ChatColor.GREEN + "Show Your Pride!"))
        {
            e.setCancelled(true);

            Sona s = utils.searchPlayerSona(p);
            if (s != null){
                if (item.hasItemMeta()){
                    ArrayList<String> lore = (ArrayList<String>) item.getLore();
                    int price = Integer.parseInt(utils.cutColor(lore.get(1)));

                    if (s.coins >= price)
                    {
                        s.coins -= price;
                        p.getInventory().addItem(item);
                        p.sendMessage(ChatColor.RED + "[-" + price + " " + coinsName + "]");
                    }
                    else
                        p.sendMessage(ChatColor.RED + "You dont have enough " + coinsName);
                }
            }
        }
    }
}
