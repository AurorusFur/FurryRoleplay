package org.aurorus.furryrp.inventories.setsona;

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
import skinsrestorer.shared.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.UUID;

public class SetSonaSpeciesInv {
    private final Main plugin;

    public SetSonaSpeciesInv(Main plugin){
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
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Select Sona Species");

        inv.setItem(0, createHead("Wolf", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTU4Nzc0NjM4NiwKICAicHJvZmlsZUlkIiA6ICJkOWQ2YTNjZDQ0ZWI0MjBlYWM2MTA2ZmQyMTNmZGRiYSIsCiAgInByb2ZpbGVOYW1lIiA6ICI5VDkiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWIzZGE3ZGE2NmNlY2RhYzYyOWIzODRjMzk4ZWNlMWQzZTdkOTcxZGZmOTRiYzgzYTQwODhiZjkyZmYzNTVhMiIKICAgIH0KICB9Cn0=\n" +
                "pME1p/+0Ry5wbRLXUT9ZIRyB7g37wg38jz5U1LH4845WACIdF2tB7Ho7k//LaaJghVN/Mbda8FV3OFZaDPrZMVizt4RWg5NQ0H9hYPB1D3NqTog+1WfCUfZHiKwWRxhHDdGsDF2EiLbGr3eQGHOukrUQRQCsyyNfBUxUX3RhFY+/kAJXfT1ew/dNbBSXQFpKzFKdoVrF0J+Myxdv14eSCNVLFfjN9o8wBrH4V1vzFX+YzPEp+jL8mSBsxDHIph4Y4pcY4hAo1XnNYBAu1CV6XIMFQkt7FzkENT16YxfGonGBq2pGBOB5YZRoaFTL4KLgTIBn9FV7Bc8dkmLAwoZ4YpTb17GOn8g2Poel3+HYDjuurj+paZzrSd7GSC6Dk5TJVK2s11bJF9AEHcqUj7qAbwiXBZuUO04HMetcuqeMKjxoLGGUNVTIOLrgrfC2OWde3/Vmwo4a5LuzjAswOIKWdRXjNOC4aeOckTcV/tRD42mJeb5mOvCVlSrn4mni1LJVbXTHUDiRy6/Fj8D7vkJLSr+yZCvnTZphI7UYvdBQJXQF5A6a0O9sFE2nyrLttIipFyFfiVXnVNpNXD28NZzKX8LI9LmM/5w29Mu9IUnNG/nANs44lsLHP4f5uWc8PX7Cn5e2ZhTUAfwCESebPedZhydEc0OfnRXQxgb7hcBVR3E=\n" +
                "4102444800000"));
        inv.setItem(1, createHead("Cat", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTU5MDA2NzYwNCwKICAicHJvZmlsZUlkIiA6ICIxOTI1MjFiNGVmZGI0MjVjODkzMWYwMmE4NDk2ZTExYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTZXJpYWxpemFibGUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWQ0ZTllMGM5MDQyZTQzMDEwYmJmYjNiNjI4NzNjNzI0YWM5NDNhN2JkNjZlMzk3NjU2MjIyNjNkYzNiZWEwNiIKICAgIH0KICB9Cn0=\n" +
                "aYBGcvU0G2V6ofxFlgwdGskDbLuNSiVkSR2yFEg0O6tXFx5Ptpaf5mLMk5o/i0NZxrt9JLqWxN/Mdm2gXwkLt3aGxSci5w+Qdf+QVSaNNQIUqawB8qW63KJF44kMhMLWLA63oQuQ6nS1DG/616hPpfg2lh4qqBbop21E6XcmdxXMd/m7i20+XkxhIQ0rBp7VDodfILFv+ytmXXH9CbM/2OKY19gMl4xQKlXyEZh/+jkrkha0wtu4DPn/sgKCzL6nSnDbDIdWOVA34hIVin/rgout0nF3OE3XAek3ZhfWN6s93DUNyAtoiNh7pME7GzcmajtJVv2g4nX7ihqLHU2Vy+ViPofaJMpj6b4t+mVp7/pSBloWjte3RPEeL2SB/7KH0k3KqQLTXBxWIGxQcnQeS8LRP1JAZktxgAxSZCT/o803AZyzxhmBugTmrPtq8i4swMtMDIWf+18lYA6IpqclOZfRENfVxubSrhGioeR/rk4lQ8xFu23WHt8OQPG8e+5HZVLShl0Zqdyq+qnrDH8OwK963V79ivjUFbEJ2WfrbTxNMtyU3pWgr3Klsk11kdN2WSmGGtxHvRX/6qfN/9HSRuN4ANzBNEQTUv8FLkH6yXtyGJQGwRrZZQPdNoa2vQCTLtqUR6tWbnWKLMb/JnTKg4FSem2wf9nhO2W+wGmDDFg=\n" +
                "4102444800000"));
        inv.setItem(2, createHead("Fox", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjRhMDM0NzQzNjQzNGViMTNkNTM3YjllYjZiNDViNmVmNGM1YTc4Zjg2ZTkxODYzZWY2MWQyYjhhNTNiODIifX19"));
        inv.setItem(3, createHead("Bat", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTYzOTY3NjIwNCwKICAicHJvZmlsZUlkIiA6ICI3MmNiMDYyMWU1MTA0MDdjOWRlMDA1OTRmNjAxNTIyZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJNb3M5OTAiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzNkOTY1YWQ4NjhkMGQ0ZDg2ZGVjNWU3MTU4ZTVhOTE1OWM1MmQ4NzQ3NTZjMzJjZDEzNjI0Y2JiNGYyYjE3MCIKICAgIH0KICB9Cn0="));
        inv.setItem(4, createHead("Dragon", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzM0ODA1OTIyNjZkZDdmNTM2ODFlZmVlZTMxODhhZjUzMWVlYTUzZGE0YWY1ODNhNjc2MTdkZWViNGY0NzMifX19"));
        inv.setItem(5, createHead("Protogen", "eyJ0aW1lc3RhbXAiOjE1ODQwODg1MjQ3NDcsInByb2ZpbGVJZCI6ImQ2MGYzNDczNmExMjQ3YTI5YjgyY2M3MTViMDA0OGRiIiwicHJvZmlsZU5hbWUiOiJCSl9EYW5pZWwiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzY3OTYxOGZhZmU0YzdiMGRjM2ExNjAyNTdiYTA3MWYyMGEyNTgxMjk1Mjg1YjUzY2U0ZDg4YzUyOTllMjI3NjMifX19"));
        inv.setItem(6, createHead("Pokemon", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19"));
        inv.setItem(7, createHead("Shark", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTY2OTkzMzc4MiwKICAicHJvZmlsZUlkIiA6ICJmNjE1NzFmMjY1NzY0YWI5YmUxODcyMjZjMTEyYWEwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJGZWxpeF9NYW5nZW5zZW4iLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDdjZmM4Njc3MTA0YTA5ZTUwZWZhYTNhYWY3MzVjOTQ3MTY3MjgxOWJhNDQ5MTMzYzMyYjZkMzRjNTM1Y2M0ZCIKICAgIH0KICB9Cn0="));
        inv.setItem(8, createHead("Sergal", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTY2OTk3ODM2OSwKICAicHJvZmlsZUlkIiA6ICI0ZWQ4MjMzNzFhMmU0YmI3YTVlYWJmY2ZmZGE4NDk1NyIsCiAgInByb2ZpbGVOYW1lIiA6ICJGaXJlYnlyZDg4IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2U2MjJiODFiNDY0Y2IxYjcxNGY2N2RhNWEwMTc5MWEzMGVhZWEzMDNlZTMzZjUxYzE4NDk5OWU5YTc2NTk4OWEiCiAgICB9CiAgfQp9"));
        inv.setItem(9, createHead("Goat", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTY3MDAzNjk4MywKICAicHJvZmlsZUlkIiA6ICJmZDYwZjM2ZjU4NjE0ZjEyYjNjZDQ3YzJkODU1Mjk5YSIsCiAgInByb2ZpbGVOYW1lIiA6ICJSZWFkIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzVjYzlmZDVkOTViYmQwMzVlMmY2ZGM5MWUzNDY3MGQ2N2Y4OTE1MWI2ZDQ1YWIxMDY0MjRlMjYxMDFiOTQ4MTQiCiAgICB9CiAgfQp9"));
        inv.setItem(10, createHead("Kaiju", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTY3MDE4NDk4NiwKICAicHJvZmlsZUlkIiA6ICIxOTI1MjFiNGVmZGI0MjVjODkzMWYwMmE4NDk2ZTExYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTZXJpYWxpemFibGUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzdkZDk0YTJkN2RhYzY1NzI5OGEwNTU1NjVkNzg3YTlhMTg1YzJmY2RmYmJlMWUwODNlZjc5ZTc2YzJkNzhkNyIKICAgIH0KICB9Cn0="));
        inv.setItem(11, createHead("Bunny", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTY3MDE0NjAwMSwKICAicHJvZmlsZUlkIiA6ICI5ZDEzZjcyMTcxM2E0N2U0OTAwZTMyZGVkNjBjNDY3MyIsCiAgInByb2ZpbGVOYW1lIiA6ICJUYWxvZGFvIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzMxZTYyYzcxNWQwYjk5OWM0MDY5Nzc1MWM3YTcxZDFlMDQ1Y2E0YjMxYmUwZjYxNTQ5NzYzMmQ5OTQ1MTFiZDMiCiAgICB9CiAgfQp9"));
        inv.setItem(12, createHead("Hyena", "ewogICJ0aW1lc3RhbXAiIDogMTU5OTY3MDIzMDI1MywKICAicHJvZmlsZUlkIiA6ICJiMGQ3MzJmZTAwZjc0MDdlOWU3Zjc0NjMwMWNkOThjYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJPUHBscyIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS8zZDc3ZTA0Yjk0ZTkzOTYzNTk2NjgwZTk1OWI2MzI5YzhiZjBjODMzYzNkMzkxMGFiYTRkMTQ1ZWM1OTlkYjg5IgogICAgfQogIH0KfQ=="));
        inv.setItem(26, createItem("Set Custom", Material.OAK_SIGN));

        p.openInventory(inv);
    }
}
