package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.PrideInv;
import org.aurorus.furryrp.inventories.WardrobeInv;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import skinsrestorer.bukkit.SkinsRestorer;

import java.util.ArrayList;

public class Wardrobe implements CommandExecutor {

    private final Main plugin;
    public Wardrobe(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("wardrobe").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
        Player p = (Player) sender;
        WardrobeInv inv = new WardrobeInv(plugin);

        inv.openInv(p);
        }
        else {
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
