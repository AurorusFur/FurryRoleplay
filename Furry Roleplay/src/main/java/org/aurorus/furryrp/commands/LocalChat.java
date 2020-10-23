package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.GiftInv;
import org.aurorus.furryrp.objects.SelectedEntity;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class LocalChat implements CommandExecutor
{

    private final Main plugin;
    public LocalChat(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("localchat").setExecutor(this);
    }

    ArrayList<Sona> SonasList = Sona.SonasList;

    public ArrayList<Player> nearbyPlayers(Player p, String rangeString)
    {
        ArrayList<Player> nearby = new ArrayList<>();
        double range = 0;
        switch (rangeString)
        {
            case "short":
                range = 3;
                break;
            case "med":
                range = 10;
                break;
            case "long":
                range = 25;
                break;
            default:
                p.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /shortchat [radius: short/med/long] [text]");
        }
        for (Entity e : p.getNearbyEntities(range, range, range))
            if (e instanceof Player)
                nearby.add((Player) e);


        return nearby;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player p = (Player) sender;
        Location pLocation = p.getLocation();
        String message = "";

        if(sender instanceof Player)
        {
            if (args.length > 1)
            {
                String distance = null;

                switch (args[0])
                {
                    case "short":
                        distance = "SHORT";
                        break;
                    case "med":
                        distance = "MEDIUM";
                        break;
                    case "long":
                        distance = "LONG";
                        break;
                    default:
                        distance = "NO ONE";
                }

                message += ChatColor.GOLD + "[LocalChat] [" + distance + "] " + p.getDisplayName() + ":" + ChatColor.WHITE;
                for (int i = 1; i<args.length; i++)
                {
                    message += " " + args[i];
                }

                p.sendMessage(message);
                for (Player p2 : nearbyPlayers(p, args[0]))
                    p2.sendMessage(message);
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /shortchat [radius: short/med/long] [text]");
            }
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
