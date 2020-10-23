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
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BuyGift implements Listener
{

    private final Main plugin;

    public BuyGift(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e)
    {
        Utils utils = new Utils();
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();
        ItemStack item = e.getCurrentItem();
        ArrayList<SelectedEntity> selectedEntity = SelectedEntity.selectedEntity;
        String coinsName = plugin.coinsName;
        Sona playersSona = utils.searchPlayerSona(p);

        if (item == null)
            return;

        if (invName.equals(ChatColor.GREEN + "Buy Gift")) {
            e.setCancelled(true);
            if (playersSona != null){
                if (item.hasItemMeta()){
                    ArrayList<String> lore = (ArrayList<String>) item.getLore();
                    int price = Integer.parseInt(utils.cutColor(lore.get(1)));

                    if (playersSona.coins >= price){
                        for (SelectedEntity s : selectedEntity){
                            if (s.id.equals(p.getUniqueId())){
                                Player p2 = Bukkit.getPlayer(s.selectedName);
                                p2.getInventory().addItem(item);
                                p.closeInventory();

                                p.sendMessage(ChatColor.RED + "[-" + price + " " + coinsName + "]");
                                p2.sendMessage(ChatColor.BLUE + "You got gift from " + ChatColor.GOLD + p.getDisplayName());
                            }
                        }
                    }
                    else{
                        p.sendMessage(ChatColor.RED + "You dont have enough " + coinsName);
                    }
                }
            }
        }
    }
}
