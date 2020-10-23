package org.aurorus.furryrp.inventories.setsona;

import com.google.common.collect.Lists;
import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.libraries.SignMenuFactory;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class SignInput {
    private final Main plugin;

    public SignInput(Main plugin){
        this.plugin = plugin;
    }

    Sona returnSona(Player p){
        ArrayList<Sona> sonasList = Sona.SonasList;

        for (Sona s : sonasList)
            if (s.id.equals(p.getUniqueId())){
                return s;
            }
        return null;
    }

    public void openSignInputName(Player p){
        plugin.getSignMenuFactory()
                    .newMenu(Lists.newArrayList("", "&a&l^^^^^^^^^^^^^^^^", "&a&lInput sona", "&a&lname here"))
                    .reopenIfFail()
                    .response((player, lines) -> {
                        if (lines[0] != null) {
                            p.sendMessage(ChatColor.GREEN + "Your sona name got changed!");
                            returnSona(p).name = lines[0];
                            Bukkit.getScheduler().runTaskLater(plugin, () -> new SetSonaInv(plugin).openInv(p, null), 2L);
                            return true;
                        }
                        return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                    })
                    .open(p);
    }

    public void openSignInputOrientation(Player p){
        plugin.getSignMenuFactory()
                .newMenu(Lists.newArrayList("", "&a&l^^^^^^^^^^^^^^^^", "&a&lInput sona", "&a&lorientation here"))
                .reopenIfFail()
                .response((player, lines) -> {
                    if (lines[0] != null) {
                        p.sendMessage(ChatColor.GREEN + "Your sona orientation got changed!");
                        returnSona(p).orientation = lines[0];
                        Bukkit.getScheduler().runTaskLater(plugin, () -> new SetSonaInv(plugin).openInv(p, null), 2L);
                        return true;
                    }
                    return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                })
                .open(p);
    }

    public void openSignInputSex(Player p){
        plugin.getSignMenuFactory()
                .newMenu(Lists.newArrayList("", "&a&l^^^^^^^^^^^^^^^^", "&a&lInput sona", "&a&lsex here"))
                .reopenIfFail()
                .response((player, lines) -> {
                    if (lines[0] != null) {
                        p.sendMessage(ChatColor.GREEN + "Your sona sex got changed!");
                        returnSona(p).sex = lines[0];
                        Bukkit.getScheduler().runTaskLater(plugin, () -> new SetSonaInv(plugin).openInv(p, null), 2L);
                        return true;
                    }
                    return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                })
                .open(p);
    }

    public void openSignInputSpecies(Player p){
        plugin.getSignMenuFactory()
                .newMenu(Lists.newArrayList("", "&a&l^^^^^^^^^^^^^^^^", "&a&lInput sona", "&a&lspecies here"))
                .reopenIfFail()
                .response((player, lines) -> {
                    if (lines[0] != null) {
                        p.sendMessage(ChatColor.GREEN + "Your sona species got changed!");
                        returnSona(p).species = lines[0];
                        Bukkit.getScheduler().runTaskLater(plugin, () -> new SetSonaInv(plugin).openInv(p, null), 2L);
                        return true;
                    }
                    return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                })
                .open(p);
    }

    public void openSignInputMood(Player p){
        plugin.getSignMenuFactory()
                .newMenu(Lists.newArrayList("", "&a&l^^^^^^^^^^^^^^^^", "&a&lInput sona", "&a&lmood here"))
                .reopenIfFail()
                .response((player, lines) -> {
                    if (lines[0] != null) {
                        p.sendMessage(ChatColor.GREEN + "Your sona mood got changed!");
                        returnSona(p).mood = lines[0];
                        Bukkit.getScheduler().runTaskLater(plugin, () -> new SetSonaInv(plugin).openInv(p, null), 2L);
                        return true;
                    }
                    return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                })
                .open(p);
    }

    public void openSignInputValueName(Player p, int value, String valueName){
        plugin.getSignMenuFactory()
                .newMenu(Lists.newArrayList(valueName, "&a&l^^^^^^^^^^^^^^^^", "&a&lInput height", "&a&lvalue name"))
                .reopenIfFail()
                .response((player, lines) -> {
                    if (lines[0] != null) {
                        Bukkit.getScheduler().runTaskLater(plugin, () -> new SetSonaHeightInv(plugin).openInv(p, value, lines[0]), 2L);
                        return true;
                    }
                    return false; // failure. becaues reopenIfFail was called, menu will reopen when closed.
                })
                .open(p);
    }
}
