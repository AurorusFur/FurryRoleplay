package org.aurorus.furryrp.inventories;

import org.aurorus.furryrp.Main;
import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class Banner
{
    String name;
    Pattern[] patterns;
    Material material;

    public Banner(String name, Pattern[] patterns, Material material)
    {
        this.name = name;
        this.patterns = patterns;
        this.material = material;
    }
}

public class PrideInv
{

    private final Main plugin;

    public PrideInv(Main plugin){
        this.plugin = plugin;
    }

    public void openInv(Player p)
    {
        String coinsName = plugin.coinsName;
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Show Your Pride!");
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        ArrayList<Banner> items = new ArrayList<>();
        items.add(new Banner("Gay", new Pattern[]{new Pattern(DyeColor.PURPLE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.CYAN, PatternType.STRIPE_TOP), new Pattern(DyeColor.LIGHT_BLUE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.BLUE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Lesbian", new Pattern[]{new Pattern(DyeColor.ORANGE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.RED, PatternType.STRIPE_TOP), new Pattern(DyeColor.MAGENTA, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Bisexual", new Pattern[]{new Pattern(DyeColor.MAGENTA, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.BLUE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Polysexual", new Pattern[]{new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM)}, Material.LIME_BANNER));
        items.add(new Banner("Pansexual", new Pattern[]{new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM)}, Material.YELLOW_BANNER));
        items.add(new Banner("Omnisexual", new Pattern[]{new Pattern(DyeColor.MAGENTA, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.BLUE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Skoliosexual", new Pattern[]{new Pattern(DyeColor.LIME, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP), new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM)}, Material.WHITE_BANNER));
        items.add(new Banner("Demisexual", new Pattern[]{new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.LIGHT_GRAY, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_MIDDLE), new Pattern(DyeColor.BLACK, PatternType.HALF_VERTICAL)}, Material.WHITE_BANNER));
        items.add(new Banner("Graysexual", new Pattern[]{new Pattern(DyeColor.PURPLE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_TOP), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.LIGHT_GRAY_BANNER));
        items.add(new Banner("Asexual", new Pattern[]{new Pattern(DyeColor.LIGHT_GRAY, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP), new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_BOTTOM)}, Material.WHITE_BANNER));
        items.add(new Banner("Polyamory", new Pattern[]{new Pattern(DyeColor.BLUE, PatternType.STRIPE_TOP), new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM)}, Material.RED_BANNER));
        items.add(new Banner("Intersex", new Pattern[]{new Pattern(DyeColor.PURPLE, PatternType.CIRCLE_MIDDLE)}, Material.YELLOW_BANNER));
        items.add(new Banner("Transsexual", new Pattern[]{new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_TOP), new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Agender", new Pattern[]{new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.BLACK, PatternType.STRIPE_TOP), new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.LIME, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Genderfluid", new Pattern[]{new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.BLACK, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.BLUE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Bigender", new Pattern[]{new Pattern(DyeColor.LIGHT_GRAY, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.LIGHT_GRAY, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Trigender", new Pattern[]{new Pattern(DyeColor.PURPLE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.PURPLE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PINK, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.LIME, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Pangender", new Pattern[]{new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP), new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.YELLOW, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Genderqueer", new Pattern[]{new Pattern(DyeColor.PURPLE, PatternType.STRIPE_TOP), new Pattern(DyeColor.GREEN, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Demigirl", new Pattern[]{new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_TOP), new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Demiboy", new Pattern[]{new Pattern(DyeColor.LIGHT_BLUE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_TOP), new Pattern(DyeColor.LIGHT_BLUE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Androgyne", new Pattern[]{new Pattern(DyeColor.PINK, PatternType.STRIPE_LEFT), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_RIGHT)}, Material.PURPLE_BANNER));
        items.add(new Banner("Intergender", new Pattern[]{new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.PINK, PatternType.STRIPE_TOP), new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.LIGHT_BLUE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("Nonbinary", new Pattern[]{new Pattern(DyeColor.WHITE, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.YELLOW, PatternType.STRIPE_TOP), new Pattern(DyeColor.PURPLE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.GRAY, PatternType.STRIPE_BOTTOM)}, Material.WHITE_BANNER));
        items.add(new Banner("Furry", new Pattern[]{new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE), new Pattern(DyeColor.WHITE, PatternType.CREEPER), new Pattern(DyeColor.WHITE, PatternType.TRIANGLE_TOP), new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_BOTTOM), new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM)}, Material.WHITE_BANNER));
        items.add(new Banner("LGBTQ+", new Pattern[]{new Pattern(DyeColor.YELLOW, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.RED, PatternType.STRIPE_TOP), new Pattern(DyeColor.BLUE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.GREEN, PatternType.STRIPE_MIDDLE)}, Material.WHITE_BANNER));
        items.add(new Banner("LGBTQ+ Ally", new Pattern[]{new Pattern(DyeColor.YELLOW, PatternType.HALF_HORIZONTAL), new Pattern(DyeColor.RED, PatternType.STRIPE_TOP), new Pattern(DyeColor.BLUE, PatternType.HALF_HORIZONTAL_MIRROR), new Pattern(DyeColor.PURPLE, PatternType.STRIPE_BOTTOM), new Pattern(DyeColor.GREEN, PatternType.STRIPE_MIDDLE), new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_BOTTOM)}, Material.WHITE_BANNER));

        for (Banner i : items)
        {
            ItemStack item = new ItemStack(i.material);
            BannerMeta meta = (BannerMeta) item.getItemMeta();
            if (i.name != null)
                meta.setDisplayName(ChatColor.BLUE + i.name + " Pride Flag");
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GREEN + "Price in " + coinsName + ":");
            lore.add(ChatColor.GREEN + ""+150);
            if (month == 5)
                lore.add(ChatColor.RED + "Happ" + ChatColor.YELLOW + "y Pri" + ChatColor.GREEN + "de Mo" + ChatColor.BLUE + "nth " + ChatColor.DARK_PURPLE + year + "!");
            meta.setLore(lore);
            for (Pattern pattern : i.patterns)
                meta.addPattern(pattern);
            item.setItemMeta(meta);
            inv.setItem(items.indexOf(i), item);
        }

        p.openInventory(inv);
    }
}
