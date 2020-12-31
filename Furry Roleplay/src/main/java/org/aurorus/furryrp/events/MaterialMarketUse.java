package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.inventories.MaterialMarketInv;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MaterialMarketUse implements Listener {
    private static Main plugin;

    public MaterialMarketUse(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        String invName = e.getView().getTitle();
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        Utils utils = new Utils();
        MaterialMarketInv market = new MaterialMarketInv(plugin);

        if (invName.equals(ChatColor.GREEN + "Material Market")){
            if (item == null)
                return;

            e.setCancelled(true);
            String itemName = item.getItemMeta().getDisplayName();
            int productCount = Integer.parseInt(utils.returnStringInt(utils.cutColor(e.getInventory().getItem(40).getItemMeta().getDisplayName())));
            int marketPage = Integer.parseInt(utils.returnStringInt(utils.cutColor(e.getInventory().getItem(49).getItemMeta().getDisplayName())));

            if (!(itemName.equals(ChatColor.RED + "- 100") || itemName.equals(ChatColor.RED + "- 10") || itemName.equals(ChatColor.RED + "- 1") || itemName.contains(ChatColor.WHITE + "Count:") || itemName.equals(ChatColor.GREEN + "+ 1") || itemName.equals(ChatColor.GREEN + "+ 10") || itemName.equals(ChatColor.GREEN + "+ 100") || itemName.equals(ChatColor.RED + "- Page") || itemName.contains(ChatColor.WHITE + "Page:") || itemName.equals(ChatColor.GREEN + "+ Page"))){
                Sona s = utils.searchPlayerSona(p);

                if(item.hasItemMeta() && item.getItemMeta().hasLore()){
                    int productPrice = Integer.parseInt(utils.cutColor(item.getLore().get(1)));

                    if (s.coins >= productPrice){
                        int freeSlots = 0;

                        for (ItemStack i : p.getInventory().getStorageContents()){
                            if (i == null){
                                freeSlots++;
                            }
                        }

                        if (productCount <= 64){
                            if (freeSlots >= 1){
                                s.coins = s.coins - productPrice;
                                p.getInventory().addItem(new ItemStack(item.getType(), productCount));
                                p.sendMessage(ChatColor.RED + "[- " + productPrice + " " + plugin.coinsName + ChatColor.WHITE + " / " + ChatColor.GREEN + "+ x" + productCount + " " + item.getType() + "]");
                            }
                            else{
                                p.sendMessage(ChatColor.RED + "You dont have free space in your inventory!");
                            }
                        }
                        else{
                            if (freeSlots >= Math.ceil(productCount / 64.0)){
                                s.coins = s.coins - productPrice;
                                p.getInventory().addItem(new ItemStack(item.getType(), productCount));
                                p.sendMessage(ChatColor.RED + "[- " + productPrice + " " + plugin.coinsName + ChatColor.WHITE + " / " + ChatColor.GREEN + "+ x" + productCount + " " + item.getType() + "]");
                            }
                            else{
                                p.sendMessage(ChatColor.RED + "You dont have free space in your inventory!");
                            }
                        }
                    }
                    else{
                        p.sendMessage(ChatColor.RED + "You dont have enough money!");
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().contains(ChatColor.GREEN + "+ 1")){
                market.openInv(p, productCount + Integer.parseInt(utils.returnStringInt(utils.cutColor(item.getItemMeta().getDisplayName()))), marketPage);
            }

            if (item.getItemMeta().getDisplayName().contains(ChatColor.RED + "- 1")){
                market.openInv(p, productCount - Integer.parseInt(utils.returnStringInt(utils.cutColor(item.getItemMeta().getDisplayName()))), marketPage);
            }

            if (item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "+ Page")){
                market.openInv(p, productCount, marketPage+1);
            }

            if (item.getItemMeta().getDisplayName().equals(ChatColor.RED + "- Page")){
                market.openInv(p, productCount, marketPage-1);
            }
        }
    }
}
