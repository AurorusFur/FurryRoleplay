package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.GiftInv;
import org.aurorus.furryrp.inventories.QuestInv;
import org.aurorus.furryrp.objects.SelectedEntity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class OpenQuest implements CommandExecutor {

    private final Main plugin;
    public OpenQuest(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("orders").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(sender instanceof Player){
            new QuestInv(plugin).openInv(p);
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
