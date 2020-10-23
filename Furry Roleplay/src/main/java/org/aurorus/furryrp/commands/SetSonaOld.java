package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class SetSonaOld implements CommandExecutor {

    private Main plugin;
    /*public SetSonaOld(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("setSona").setExecutor(this);
    }*/

    void Search(UUID id, String type, String value){
        ArrayList<Sona> SonasList = Sona.SonasList;
        for (Sona s : SonasList){
            if (s.id.equals(id)){
                switch (type){
                    case "age":
                        s.age = value;
                        break;
                    case "species":
                        s.species = value;
                        break;
                    case "orientation":
                        s.orientation = value;
                        break;
                    case "sex":
                        s.sex = value;
                        break;
                    case "name":
                        s.name = value;
                        break;
                    case "mood":
                        s.mood = value;
                        break;
                    case "height":
                        s.height = value;
                        break;
                }
            }
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(sender instanceof Player){
            if (args.length == 2){
                switch (args[0]){
                    case "age":
                        sender.sendMessage(ChatColor.GREEN + "age set to : " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    case "species":
                        sender.sendMessage(ChatColor.GREEN + "species set to: " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    case "orientation":
                        sender.sendMessage(ChatColor.GREEN + "orientation set to : " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    case "sex":
                        sender.sendMessage(ChatColor.GREEN + "sex set to: " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    case "name":
                        sender.sendMessage(ChatColor.GREEN + "name set to : " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    case "mood":
                        sender.sendMessage(ChatColor.GREEN + "mood set to : " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    case "height":
                        sender.sendMessage(ChatColor.GREEN + "height set to : " + args[1]);
                        Search(p.getUniqueId(), args[0], args[1]);
                        break;
                    default:
                        sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /setsona age [value] \n /setsona species [value] \n /setsona orientation [value] \n /setsona sex [value] \n /setsona name [value] \n /setsona mood [value] \n /setsona height [value]");
                        break;
                }

            }
            else{
                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /setsona age [value] \n /setsona species [value] \n /setsona orientation [value] \n /setsona sex [value] \n /setsona name [value] \n /setsona mood [value] \n /setsona height [value]");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
