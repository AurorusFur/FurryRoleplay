package org.aurorus.furryrp.inventories.setsona;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;

public class SetSonaSexInv {
    private final Main plugin;

    public SetSonaSexInv(Main plugin){
        this.plugin = plugin;
    }

    ItemStack createHead(String name, String b64stringtexture){
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", b64stringtexture));
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + name);

        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);

        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException e) {
            e.printStackTrace();
        }

        item.setItemMeta(meta);

        return item;
    }

    ItemStack createItem(String name, Material material){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + name);
        item.setItemMeta(meta);

        return item;
    }

    public void openInv(Player p){
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GREEN + "Select Sona Sex");

        inv.setItem(0, createHead("Male", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTU5MTA2Nzg0NCwKICAicHJvZmlsZUlkIiA6ICJiMGQ0YjI4YmMxZDc0ODg5YWYwZTg2NjFjZWU5NmFhYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJNaW5lU2tpbl9vcmciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRhNTA2NTUxOWJiMmM4NTliOTZiZDEwNTY1NGNiMWFiNTUyYjU5NDhiM2YzZWIzOWJmNjlmNWE5OTEwNzkxIgogICAgfQogIH0KfQ==\n" +
                "K9PdkK55hEaLeJOwouxiD+xf/6LGQtXdnJFJ0tjotO5N27pSfOw0o4DT4X5S3ufcwdRL2zZ1V7RGS1CEsGPocuYIXZnqLfnSRmDrVlefueJxC6pYG7ouLM5kw0WqT2NK93gn3w2DOfnY1MhrNuk95uotKrfB17hqorhmlNG7p1nRD/NBLJTOWVEiM1+HDVZNeV7g2IqJT7H1IRoDoWbps4VqdAIBuz0fUhWA25qWNFtzniYEUIoR2HbHTfeLraH54CGU/ZhqXADZxcQ+AwtLVxUSYYmoF74a6x1fL/0wtQ8KDp0LRnPDQM5HOeB7HrMPFnOXZ869nz+Z2GdpUq0rcgeRhVMmcWkyBC5RQCuFKUsenPZSmvf7/cgdIAE+HPqRgLxJAPNr+afxPJfaZi+xmIESUx41qMiXB2Fz3PZIYv5shQSPE5SconUtxbjZNe/HI34I6I/4ipcP9T9B4dRrByvZ7L7+Bv1jC7l6zw6CgMRn/erWsFe1HH8Vu7+Zrli03cyecMq2MVlo2hF55tHZncSqvWWArrRn2CCJL6DmkEJEVKl5dq9vB1IEEuTm5AJwGANzf/qoFV+hvw0XSUwum52qp3F4zuxn/o3Mrqe8gY9ykMUTuvDu+t71Diy224L3a0E8jP+g9nTCLf/pJReGWM4A5JVyUsGam9af8ck+3KA=\n" +
                "4102444800000"));
        inv.setItem(1, createHead("Female", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTU5MTA5MjI0MCwKICAicHJvZmlsZUlkIiA6ICI3NzI3ZDM1NjY5Zjk0MTUxODAyM2Q2MmM2ODE3NTkxOCIsCiAgInByb2ZpbGVOYW1lIiA6ICJsaWJyYXJ5ZnJlYWsiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGUzMGE4OGQ5ODM4OTMyZTMxNjRkNzMxMGNjMjBlYzEzN2Q1N2UwYjNhZjNlYjEyM2U5ODM5ZGRlOTJkNGNlZiIKICAgIH0KICB9Cn0=\n" +
                "HbPm0vBKooCjWLI7N7nXdHJ2LY7/k0xALu4Sm0Kd1cz/Pp33mYd1jpl7zkr00FhaV5T/FHEA9FuALBb3VrjYmfgavJmLRyuiE3pu8DMLG2n8M7uHOIs+KIs0FdNpiWpMDqLrIfzrcbOwJF/nQksHhLYfGaY8VH5FPKPOKiLnSvZdve+XCVRceovxopIHgwUYAB1Ja7MOWuD1X/R4JiVrX37Kf6+IKV+VwDLcQ0OIW6aY8DVs2jdtXfwztxDb7fDnvlqWNkWn6iatlxIiDMV00qaLmSelf6P5NOMdIFRDeCur02ZHQXLy1Cl6AcdtWk1NYfiz3WXN/VZeOlQHaXfC5+q9lQt6QtXVzYB4qlcNL/B9EcY+ztZcXurJbc2xBUWLk72HrEAQ63iw9rwT+iWB80znbwcdBjNqiIj8mZ+uI40HzYUegprQIM/MgGawrMzGdoYm/uQrv6tQ4XwJ6CdlCA7YNlPOfTAprdqRgmHxg+rju9snGKkvWW3UqEj39aTUB1EwXQjbyahmdH8I0tbnCh+7xDlXYYIxHUxTbit8EJVn4aq8jJTx7pXqvk3BTTThwTRSYE9VW8ObshsonVmzG2DuDgyxJElNPay/L3poq1PemzhOF+1vmC5Iavb0Dnd5AkDEJZWFqNkZAPDsd1RFvetgaFmQY795o03H/APuo/U=\n" +
                "4102444800000"));
        inv.setItem(8, createItem("Set Custom", Material.OAK_SIGN));

        p.openInventory(inv);
    }
}
