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
import java.util.UUID;

public class InfoSona implements CommandExecutor {

    private final Main plugin;
    public InfoSona(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("infoSona").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        ArrayList<Sona> SonasList = Sona.SonasList;
        int valid = 1;
        String coinsName = plugin.coinsName;

        if(sender instanceof Player){
            if (args.length == 1){
                for (Sona s : SonasList){
                    if (Bukkit.getPlayer(s.id) != null){
                        if (Bukkit.getPlayer(s.id).getName().equals(args[0])){
                            p.sendMessage(ChatColor.GOLD + "------------------\n" + ChatColor.BLUE + "Owner: " + Bukkit.getPlayer(s.id).getDisplayName() + ChatColor.BLUE + "\nName: " + s.name + "\nAge: " + s.age + "\nOrientation: " + s.orientation + "\nSex: " + s.sex + "\nSpecies: " + s.species + "\nHeight: " + s.height + ChatColor.GREEN + "\nMood: " + s.mood + ChatColor.GREEN + "\n" + coinsName + ": " + s.coins + ChatColor.GOLD + "\n------------------");
                            valid = 0;
                        }
                    }
                }
                if (valid == 1)
                    p.sendMessage(ChatColor.RED + "Player not found");
            }
            else{
                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /infosona [playername]");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
