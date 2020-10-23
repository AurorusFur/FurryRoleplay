package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.GiftInv;
import org.aurorus.furryrp.inventories.PrideInv;
import org.aurorus.furryrp.objects.SelectedEntity;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Pride implements CommandExecutor
{

    private final Main plugin;
    public Pride(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("pride").setExecutor(this);
    }

    ArrayList<Sona> SonasList = Sona.SonasList;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player p = (Player) sender;

        if(sender instanceof Player)
        {
            PrideInv pride = new PrideInv(plugin);
            pride.openInv(p);
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
