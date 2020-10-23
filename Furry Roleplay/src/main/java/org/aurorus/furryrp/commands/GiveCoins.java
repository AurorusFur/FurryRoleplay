package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GiveCoins implements CommandExecutor {

    private final Main plugin;
    public GiveCoins(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("giveCoins").setExecutor(this);
    }

    ArrayList<Sona> SonasList = Sona.SonasList;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        String coinsName = plugin.coinsName;
        Utils utils = new Utils();

        if(sender instanceof Player){
            boolean valid = true;
            if (args.length == 2){
                for (Sona s : SonasList){
                    if (valid){
                        if (Bukkit.getPlayer(s.id) != null){
                            if (Bukkit.getPlayer(s.id).getName().equals(args[0])){
                                Player p2 = Bukkit.getPlayer(s.id);
                                Sona s2 = utils.searchPlayerSona(p);
                                if (s2 != null){
                                    if (s2.coins >= Integer.parseInt(args[1])){
                                        s2.coins -= Integer.parseInt(args[1]);
                                        s.coins += Integer.parseInt(args[1]);
                                        p.sendMessage(ChatColor.GREEN + "You give " + args[1] + " " + coinsName + " to " + args[0]);
                                        p2.sendMessage(ChatColor.GREEN + "You have got " + args[1] + " " + coinsName + " from " + p.getDisplayName());
                                    }
                                    else{
                                        p.sendMessage(ChatColor.RED + "You dont have enough " + coinsName + "!");
                                    }
                                    valid = false;
                                }
                            }
                        }
                    }
                }
                if (valid)
                    p.sendMessage(ChatColor.RED + "Player not found");
            }
            else{
                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /givecoins [playername] [value]");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
