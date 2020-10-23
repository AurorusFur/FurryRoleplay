package org.aurorus.furryrp.commands;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.ItemPriced;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class ManageGifts implements CommandExecutor {
    private final Main plugin;
    public ManageGifts(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("managegifts").setExecutor(this);
    }

    void setItem(Player p, String[] args, ArrayList<ItemPriced> items){
        if (p.getInventory().getItemInMainHand().getAmount() != 0){
            ItemStack item = p.getInventory().getItemInMainHand();
            int modeldata = 0;
            String displayName;
            if (item.getItemMeta().hasDisplayName())
                displayName = item.getItemMeta().getDisplayName();
            else
                displayName = item.getType().name();
            p.sendMessage(ChatColor.GREEN + "Name: " + displayName + ChatColor.GREEN + " Slot: " + args[1] + " Price: " + args[2] + " added!");
            ArrayList<String> lore = new ArrayList<>();
            if (item.getLore() != null){
                for (String s : item.getLore())
                    lore.add(s);
            }
            if (item.getItemMeta().hasCustomModelData())
                modeldata = item.getItemMeta().getCustomModelData();

            items.set(Integer.parseInt(args[1]), new ItemPriced("Item", Integer.parseInt(args[2]), displayName, item.getType(), item.getAmount(), lore, modeldata, args[3]));
        }
        else
            p.sendMessage(ChatColor.RED + "You need to have item in hand");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        ArrayList<ItemPriced> items = ItemPriced.items;

        if(sender instanceof Player){
            if (p.hasPermission("furryrp.managegifts")){
                if (args.length > 0){
                    switch (args[0]){
                        case "remove":
                            if (args[1] != null && args.length == 2){
                                sender.sendMessage(ChatColor.RED + "Item " + args[1] + " removed!");
                                items.set(Integer.parseInt(args[1]), null);
                            }
                            else
                                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n /managegifts remove, [slot] [price]\n /managegifts set, [slot] [price] [name color: BLUE, RED, GREEN, YELLOW, GOLD, NONE]");
                            break;
                        case "set":
                            if (args[1] != null && args.length == 4){
                                switch (args[3]){
                                    case "BLUE":
                                        setItem(p, args, items);
                                        break;
                                    case "RED":
                                        setItem(p, args, items);
                                        break;
                                    case "GREEN":
                                        setItem(p, args, items);
                                        break;
                                    case "YELLOW":
                                        setItem(p, args, items);
                                        break;
                                    case "GOLD":
                                        setItem(p, args, items);
                                        break;
                                    case "NONE":
                                        setItem(p, args, items);
                                        break;
                                    default:
                                        sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n/managegifts remove, [slot]\n/managegifts set [slot] [price] [name color: BLUE, RED, GREEN, YELLOW, GOLD, NONE]");
                                }
                            }
                            else
                                sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n/managegifts remove, [slot]\n/managegifts set [slot] [price] [name color: BLUE, RED, GREEN, YELLOW, GOLD, NONE]");
                            break;
                        default:
                            sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n/managegifts remove, [slot]\n/managegifts set [slot] [price] [name color: BLUE, RED, GREEN, YELLOW, GOLD, NONE]");
                    }
                }
                else{
                    sender.sendMessage(ChatColor.RED + "Invalid Action!"+ChatColor.WHITE+"\n/managegifts remove, [slot]\n/managegifts set [slot] [price] [name color: BLUE, RED, GREEN, YELLOW, GOLD, NONE]");
                }
            }
            else
                p.sendMessage(ChatColor.RED + "You dont have permission to use this command.");
        }
        else{
            sender.sendMessage(ChatColor.RED + "This command can be executed only as player!");
        }
        return false;
    }
}
