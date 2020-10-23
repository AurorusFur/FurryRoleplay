package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.inventories.setsona.SetSonaAgeInv;
import org.aurorus.furryrp.inventories.setsona.SetSonaHeightInv;
import org.aurorus.furryrp.inventories.setsona.SetSonaInv;
import org.aurorus.furryrp.inventories.setsona.SignInput;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SetSonaClick implements Listener {
    private final Main plugin;

    public SetSonaClick(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void invClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();
        ItemStack item = e.getCurrentItem();
        SetSonaAgeInv setsonaageinv = new SetSonaAgeInv(plugin);
        SetSonaHeightInv setsonaheightinv = new SetSonaHeightInv(plugin);
        SignInput signInput = new SignInput(plugin);
        Utils utils = new Utils();

        if (item == null){
            return;
        }

        if (invName.equals(ChatColor.GREEN + "Setup Sona Info")){
            e.setCancelled(true);

            if (item.getType().equals(Material.PAPER))
                new SetSonaInv(plugin).openInv(p, item.getItemMeta().getDisplayName());
        }

        if (invName.equals(ChatColor.GREEN + "Set Sona Age")){
            e.setCancelled(true);
            ItemStack value = e.getInventory().getItem(4);

            if (item.getType().equals(Material.RED_STAINED_GLASS_PANE))
                setsonaageinv.openInv(p, utils.returnCuttedInt(value.getItemMeta().getDisplayName())+Integer.parseInt(utils.cutColor(item.getItemMeta().getDisplayName())));
            if (item.getType().equals(Material.GREEN_STAINED_GLASS_PANE))
                setsonaageinv.openInv(p, utils.returnCuttedInt(value.getItemMeta().getDisplayName())+Integer.parseInt(utils.cutColor(item.getItemMeta().getDisplayName())));
            if (item.getType().equals(Material.PAPER)){
                utils.searchPlayerSona(p).age = utils.cutColor(item.getItemMeta().getDisplayName());
                p.sendMessage(ChatColor.GREEN + "Your sona age got changed!");
                new SetSonaInv(plugin).openInv(p, null);
            }
        }

        if (invName.equals(ChatColor.GREEN + "Set Sona Height")){
            e.setCancelled(true);
            ItemStack value = e.getInventory().getItem(4);

            if (item.getType().equals(Material.RED_STAINED_GLASS_PANE))
                setsonaheightinv.openInv(p, utils.returnCuttedInt(value.getItemMeta().getDisplayName())+Integer.parseInt(utils.cutColor(item.getItemMeta().getDisplayName())), utils.returnStringInt(value.getItemMeta().getDisplayName()));
            if (item.getType().equals(Material.GREEN_STAINED_GLASS_PANE))
                setsonaheightinv.openInv(p, utils.returnCuttedInt(value.getItemMeta().getDisplayName())+Integer.parseInt(utils.cutColor(item.getItemMeta().getDisplayName())), utils.returnStringInt(value.getItemMeta().getDisplayName()));
            if (item.getType().equals(Material.PAPER)){
                utils.searchPlayerSona(p).height = utils.cutColor(item.getItemMeta().getDisplayName());
                p.sendMessage(ChatColor.GREEN + "Your sona height got changed!");
                new SetSonaInv(plugin).openInv(p, null);
            }
            if (item.getType().equals(Material.OAK_SIGN))
                signInput.openSignInputValueName(p, utils.returnCuttedInt(value.getItemMeta().getDisplayName()), utils.returnStringInt(value.getItemMeta().getDisplayName()));
        }

        if (invName.equals(ChatColor.GREEN + "Select Sona Orientation")){
            e.setCancelled(true);

            if (item.getType().equals(Material.OAK_SIGN))
                signInput.openSignInputOrientation(p);
            if (item.getType().equals(Material.PLAYER_HEAD)){
                utils.searchPlayerSona(p).orientation = utils.cutColor(item.getItemMeta().getDisplayName());
                p.sendMessage(ChatColor.GREEN + "Your sona orientation got changed!");
                new SetSonaInv(plugin).openInv(p, null);
            }
        }

        if (invName.equals(ChatColor.GREEN + "Select Sona Species")){
            e.setCancelled(true);

            if (item.getType().equals(Material.OAK_SIGN))
                signInput.openSignInputSpecies(p);
            if (item.getType().equals(Material.PLAYER_HEAD)){
                utils.searchPlayerSona(p).species = utils.cutColor(item.getItemMeta().getDisplayName());
                p.sendMessage(ChatColor.GREEN + "Your sona species got changed!");
                new SetSonaInv(plugin).openInv(p, null);
            }

        }

        if (invName.equals(ChatColor.GREEN + "Select Sona Sex")){
            e.setCancelled(true);

            if (item.getType().equals(Material.OAK_SIGN))
                signInput.openSignInputSex(p);
            if (item.getType().equals(Material.PLAYER_HEAD)){
                utils.searchPlayerSona(p).sex = utils.cutColor(item.getItemMeta().getDisplayName());
                p.sendMessage(ChatColor.GREEN + "Your sona sex got changed!");
                new SetSonaInv(plugin).openInv(p, null);
            }
        }
    }
}
