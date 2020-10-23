package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GiveCoords implements CommandExecutor {

    private final Main plugin;
    public GiveCoords(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("giveCoords").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        int valid = 1;

        if(sender instanceof Player){
            if (args.length == 1){
                for (Player p2 : Bukkit.getOnlinePlayers()){
                    if (args[0].equals(p2.getName())){
                        p2.sendMessage(ChatColor.BLUE + "" + p.getDisplayName() + " Coords: " + ChatColor.GOLD + " X:" + p.getLocation().getBlockX() + " Y:" + p.getLocation().getBlockY() + " Z:" + p.getLocation().getBlockZ());
                        p.sendMessage(ChatColor.GREEN + "Coords shared!");
                        valid = 0;
                    }
                }

                if (valid == 1)
                    p.sendMessage(ChatColor.RED + "Player not found");
            }
            else{
                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /givecoords [playername]");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
