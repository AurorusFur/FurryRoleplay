package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.inventories.GiftInv;
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

public class Gift implements CommandExecutor {

    private final Main plugin;
    public Gift(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("gift").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        boolean control = true;

        if(sender instanceof Player){
            if (args.length == 1){
                GiftInv inv = new GiftInv(plugin);
                ArrayList<SelectedEntity> selectedEntity = SelectedEntity.selectedEntity;

                if (!(p.getName().equals(args[0]))){
                    if (selectedEntity.size() != 0){
                        for (SelectedEntity s : selectedEntity){
                            if (s.id.equals(p.getUniqueId())){
                                s.selectedName = args[0];
                                control = false;
                            }
                        }
                        if (control)
                            selectedEntity.add(new SelectedEntity(p.getUniqueId(), null, args[0]));
                    }
                    else{
                        selectedEntity.add(new SelectedEntity(p.getUniqueId(), null, args[0]));
                    }

                    control = true;

                    if (control)
                        for (World w : Bukkit.getWorlds())
                            for (Player p2 : Bukkit.getWorld(w.getName()).getPlayers()){
                                if (p2.getName().equals(args[0])){
                                    inv.openInv(p);
                                    p.sendMessage(ChatColor.GREEN + "Gift for " + p2.getDisplayName());
                                    control = false;
                                }
                            }
                    if (control)
                        p.sendMessage(ChatColor.RED + "Player not found");
                }
                else if (p.getName().equals(args[0]) && plugin.giftingYourself){
                    if (selectedEntity.size() != 0){
                        for (SelectedEntity s : selectedEntity){
                            if (s.id.equals(p.getUniqueId())){
                                s.selectedName = args[0];
                                control = false;
                            }
                        }
                        if (control)
                            selectedEntity.add(new SelectedEntity(p.getUniqueId(), null, args[0]));
                    }
                    else{
                        selectedEntity.add(new SelectedEntity(p.getUniqueId(), null, args[0]));
                    }

                    control = true;

                    if (control)
                        for (World w : Bukkit.getWorlds())
                            for (Player p2 : Bukkit.getWorld(w.getName()).getPlayers()){
                                if (p2.getName().equals(args[0])){
                                    inv.openInv(p);
                                    p.sendMessage(ChatColor.GREEN + "Gift for " + p2.getDisplayName());
                                    control = false;
                                }
                            }
                    if (control)
                        p.sendMessage(ChatColor.RED + "Player not found");
                }
                else{
                    p.sendMessage(ChatColor.RED + "You cant buy gift for yourself");
                }
            }
            else{
                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /gift [playername]");
            }
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
