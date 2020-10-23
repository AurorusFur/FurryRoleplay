package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.inventories.QuestInv;
import org.aurorus.furryrp.objects.Quest;
import org.aurorus.furryrp.objects.QuestItem;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class QuestsClick implements Listener
{

    private final Main plugin;

    public QuestsClick(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();
        ItemStack item = e.getCurrentItem();
        Utils utils = new Utils();

        if (item == null)
            return;

        if (invName.contains(ChatColor.GREEN + "Current Order"))
        {
            e.setCancelled(true);

            if (!item.getItemMeta().getDisplayName().contains("Skipped Orders") && !item.getItemMeta().getDisplayName().contains("Finished Orders") && !item.getItemMeta().getDisplayName().contains("Skip Order")){
                for (ItemStack i : p.getInventory()){
                    Sona s = utils.searchPlayerSona(p);

                    if (s != null){
                        for (QuestItem q : s.quest.items){
                            if (!q.isCompleted){
                                if (i != null){
                                    if (i.getType().toString().equals(q.item.toString()) && i.getAmount() >= q.needed){
                                        i.subtract(q.needed);
                                        q.isCompleted = true;
                                        p.sendMessage(ChatColor.GREEN + "[-" + q.needed + "] " + q.item);
                                    }
                                }
                            }
                        }
                        new QuestInv(plugin).openInv(p);
                    }
                }
            }

            if (item.getItemMeta().getDisplayName().contains("Skip Order")){
                new QuestInv(plugin).skipQuest(p);
                new QuestInv(plugin).openInv(p);
            }
        }
    }
}
