package org.aurorus.furryrp.inventories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.ItemPriced;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;

public class GiftInv {

    private final Main plugin;

    public GiftInv(Main plugin){
        this.plugin = plugin;
    }

    public void openInv(Player p)
    {
        String coinsName = plugin.coinsName;
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Buy Gift");
        ArrayList<ItemPriced> items = ItemPriced.items;

        for (ItemPriced i : items){
            if (i != null){
                ItemStack item = new ItemStack(i.material, i.count);
                ItemMeta meta = item.getItemMeta();
                if (!i.nameColor.equals("NONE"))
                    meta.setDisplayName(ChatColor.valueOf(i.nameColor) + i.name);
                else
                    meta.setDisplayName(ChatColor.WHITE + i.name);
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.GREEN + "Price in " + coinsName + ":");
                lore.add(ChatColor.GREEN + ""+i.price);
                meta.setCustomModelData(i.modeldata);
                if (i.lore != null)
                    for (String s : i.lore)
                        lore.add(s);
                meta.setLore(lore);
                item.setItemMeta(meta);
                inv.setItem(items.indexOf(i), item);
            }
        }

        p.openInventory(inv);
    }
}
