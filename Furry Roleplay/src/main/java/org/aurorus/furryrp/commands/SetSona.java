package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.setsona.SetSonaInv;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class SetSona implements CommandExecutor {

    private final Main plugin;
    public SetSona(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("setSona").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof Player){
            new SetSonaInv(plugin).openInv(p, null);
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
