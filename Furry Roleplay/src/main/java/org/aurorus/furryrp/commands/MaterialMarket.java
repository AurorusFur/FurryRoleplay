package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.MaterialMarketInv;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaterialMarket implements CommandExecutor {
    private final Main plugin;

    public MaterialMarket(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("market").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if(sender instanceof Player){
            MaterialMarketInv market = new MaterialMarketInv(plugin);
            market.openInv(p, 1, 0);
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
