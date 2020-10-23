package org.aurorus.furryrp.inventories;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.aurorus.furryrp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import skinsrestorer.bukkit.SkinsRestorer;
import skinsrestorer.bukkit.SkinsRestorerBukkitAPI;
import skinsrestorer.shared.utils.ReflectionUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class WardrobeInv
{

    private final Main plugin;

    public WardrobeInv(Main plugin){
        this.plugin = plugin;
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 5);
    }

    private void setSkin(ItemStack head, String b64stringtexture) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        propertyMap.put("textures", new Property("textures", b64stringtexture));
        ItemMeta headMeta = head.getItemMeta();
        Class<?> headMetaClass = headMeta.getClass();
        try
        {
            ReflectionUtil.getField(headMetaClass, "profile", GameProfile.class, 0).set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
    }

    public void openInv(Player p) {
        SkinsRestorer skinsRestorer = JavaPlugin.getPlugin(SkinsRestorer.class);
        SkinsRestorerBukkitAPI skinsRestorerBukkitAPI = skinsRestorer.getSkinsRestorerBukkitAPI();
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.GREEN + "Wardrobe");
        File userdata = new File(skinsRestorer.getDataFolder() + File.separator + "Skins" + File.separator);
        int skinIndex = 0;

        for (int i = 0; i<userdata.listFiles().length && i<27; i++){
            File[] files = userdata.listFiles();
            if (files[i].getName().contains(p.getUniqueId().toString())) {
                ItemStack item = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta meta = (SkullMeta) item.getItemMeta();
                meta.setDisplayName(removeLastChar(files[i].getName()));
                Object skinObject = skinsRestorerBukkitAPI.getSkinData(removeLastChar(files[i].getName()));
                item.setItemMeta(meta);
                setSkin(item, ((Property) skinObject).getValue());
                inv.setItem(skinIndex, item);
                skinIndex++;
            }
        }

        for (int i = 27; i<=34; i++) {
            ItemStack request = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta requestMeta = request.getItemMeta();
            requestMeta.setDisplayName(ChatColor.GREEN + "Generate Skin File");
            request.setItemMeta(requestMeta);
            inv.setItem(i, request);
        }

        ItemStack using = new ItemStack(Material.BOOK);
        ItemMeta usingMeta = using.getItemMeta();
        usingMeta.setDisplayName(ChatColor.BLUE + "How to Use");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "1: Use generator to create skin file");
        lore.add(ChatColor.WHITE + "2: Contact with server administration and send your skin file");
        lore.add(ChatColor.WHITE + "3: Choose your skin from wardrobe list");
        lore.add(ChatColor.WHITE + "4: Enjoy your new skin!");
        usingMeta.setLore(lore);
        using.setItemMeta(usingMeta);
        inv.setItem(35, using);

        p.openInventory(inv);
    }
}
