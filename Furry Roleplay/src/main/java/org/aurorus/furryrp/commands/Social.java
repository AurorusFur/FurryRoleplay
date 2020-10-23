package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.PrideInv;
import org.aurorus.furryrp.inventories.SocialInv;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Social implements CommandExecutor
{

    private final Main plugin;
    public Social(Main plugin)
    {
        this.plugin = plugin;
        plugin.getCommand("social").setExecutor(this);
    }

    ArrayList<Sona> SonasList = Sona.SonasList;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player p = (Player) sender;

        if(sender instanceof Player)
        {
            SocialInv inv = new SocialInv(plugin);
            inv.openInv(p);
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
