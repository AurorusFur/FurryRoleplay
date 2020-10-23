package org.aurorus.furryrp.inventories;

import org.aurorus.furryrp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

class ItemPriced{
    int price;
    Material material;

    ItemPriced(int price, Material material){
        this.price = price;
        this.material = material;
    }
}

public class MaterialMarketInv {
    private final Main plugin;

    public MaterialMarketInv(Main plugin){
        this.plugin = plugin;
    }

    ItemPriced[] itemsList = {
            new ItemPriced(1, Material.STONE),
            new ItemPriced(1, Material.GRANITE),
            new ItemPriced(1, Material.POLISHED_GRANITE),
            new ItemPriced(1, Material.DIORITE),
            new ItemPriced(1, Material.POLISHED_DIORITE),
            new ItemPriced(1, Material.ANDESITE),
            new ItemPriced(1, Material.POLISHED_ANDESITE),
            new ItemPriced(2, Material.GRASS_BLOCK),
            new ItemPriced(1, Material.DIRT),
            new ItemPriced(2, Material.COARSE_DIRT),
            new ItemPriced(2, Material.PODZOL),
            new ItemPriced(1, Material.COBBLESTONE),
            new ItemPriced(1, Material.OAK_PLANKS),
            new ItemPriced(1, Material.SPRUCE_PLANKS),
            new ItemPriced(1, Material.BIRCH_PLANKS),
            new ItemPriced(1, Material.JUNGLE_PLANKS),
            new ItemPriced(1, Material.ACACIA_PLANKS),
            new ItemPriced(1, Material.DARK_OAK_PLANKS),
            new ItemPriced(1, Material.SAND),
            new ItemPriced(1, Material.RED_SAND),
            new ItemPriced(1, Material.GRAVEL),
            new ItemPriced(1, Material.OAK_LOG),
            new ItemPriced(1, Material.SPRUCE_LOG),
            new ItemPriced(1, Material.BIRCH_LOG),
            new ItemPriced(1, Material.JUNGLE_LOG),
            new ItemPriced(1, Material.ACACIA_LOG),
            new ItemPriced(1, Material.DARK_OAK_LOG),
            new ItemPriced(1, Material.STRIPPED_OAK_LOG),
            new ItemPriced(1, Material.STRIPPED_SPRUCE_LOG),
            new ItemPriced(1, Material.STRIPPED_BIRCH_LOG),
            new ItemPriced(1, Material.STRIPPED_JUNGLE_LOG),
            new ItemPriced(1, Material.STRIPPED_ACACIA_LOG),
            new ItemPriced(1, Material.STRIPPED_DARK_OAK_LOG),
            new ItemPriced(1, Material.STRIPPED_OAK_WOOD),
            new ItemPriced(1, Material.STRIPPED_SPRUCE_WOOD),
            new ItemPriced(1, Material.STRIPPED_BIRCH_WOOD),
            new ItemPriced(1, Material.STRIPPED_JUNGLE_WOOD),
            new ItemPriced(1, Material.STRIPPED_ACACIA_WOOD),
            new ItemPriced(1, Material.STRIPPED_DARK_OAK_WOOD),
            new ItemPriced(1, Material.OAK_WOOD),
            new ItemPriced(1, Material.SPRUCE_WOOD),
            new ItemPriced(1, Material.BIRCH_WOOD),
            new ItemPriced(1, Material.JUNGLE_WOOD),
            new ItemPriced(1, Material.ACACIA_WOOD),
            new ItemPriced(1, Material.DARK_OAK_WOOD),
            new ItemPriced(5, Material.SPONGE),
            new ItemPriced(5, Material.WET_SPONGE),
            new ItemPriced(1, Material.GLASS),
            new ItemPriced(1, Material.SANDSTONE),
            new ItemPriced(1, Material.SMOOTH_SANDSTONE),
            new ItemPriced(1, Material.CHISELED_SANDSTONE),
            new ItemPriced(1, Material.WHITE_WOOL),
            new ItemPriced(1, Material.ORANGE_WOOL),
            new ItemPriced(1, Material.MAGENTA_WOOL),
            new ItemPriced(1, Material.LIGHT_BLUE_WOOL),
            new ItemPriced(1, Material.YELLOW_WOOL),
            new ItemPriced(1, Material.LIME_WOOL),
            new ItemPriced(1, Material.PINK_WOOL),
            new ItemPriced(1, Material.GRAY_WOOL),
            new ItemPriced(1, Material.LIGHT_GRAY_WOOL),
            new ItemPriced(1, Material.CYAN_WOOL),
            new ItemPriced(1, Material.PURPLE_WOOL),
            new ItemPriced(1, Material.BLUE_WOOL),
            new ItemPriced(1, Material.BROWN_WOOL),
            new ItemPriced(1, Material.GREEN_WOOL),
            new ItemPriced(1, Material.RED_WOOL),
            new ItemPriced(1, Material.BLACK_WOOL),
            new ItemPriced(4, Material.SMOOTH_QUARTZ),
            new ItemPriced(1, Material.SMOOTH_RED_SANDSTONE),
            new ItemPriced(1, Material.SMOOTH_STONE),
            new ItemPriced(1, Material.BRICKS),
            new ItemPriced(1, Material.MOSSY_COBBLESTONE),
            new ItemPriced(5, Material.OBSIDIAN),
            new ItemPriced(4, Material.PURPUR_BLOCK),
            new ItemPriced(4, Material.PURPUR_PILLAR),
            new ItemPriced(2, Material.ICE),
            new ItemPriced(2, Material.SNOW_BLOCK),
            new ItemPriced(1, Material.CLAY),
            new ItemPriced(2, Material.NETHERRACK),
            new ItemPriced(2, Material.SOUL_SAND),
            new ItemPriced(3, Material.GLOWSTONE),
            new ItemPriced(1, Material.STONE_BRICKS),
            new ItemPriced(1, Material.MOSSY_STONE_BRICKS),
            new ItemPriced(1, Material.CRACKED_STONE_BRICKS),
            new ItemPriced(1, Material.CHISELED_STONE_BRICKS),
            new ItemPriced(5, Material.MYCELIUM),
            new ItemPriced(3, Material.NETHER_BRICKS),
            new ItemPriced(4, Material.END_STONE),
            new ItemPriced(4, Material.END_STONE_BRICKS),
            new ItemPriced(4, Material.CHISELED_QUARTZ_BLOCK),
            new ItemPriced(4, Material.QUARTZ_BLOCK),
            new ItemPriced(4, Material.QUARTZ_PILLAR),
            new ItemPriced(1, Material.WHITE_TERRACOTTA),
            new ItemPriced(1, Material.ORANGE_TERRACOTTA),
            new ItemPriced(1, Material.MAGENTA_TERRACOTTA),
            new ItemPriced(1, Material.LIGHT_BLUE_TERRACOTTA),
            new ItemPriced(1, Material.YELLOW_TERRACOTTA),
            new ItemPriced(1, Material.LIME_TERRACOTTA),
            new ItemPriced(1, Material.PINK_TERRACOTTA),
            new ItemPriced(1, Material.GRAY_TERRACOTTA),
            new ItemPriced(1, Material.LIGHT_GRAY_TERRACOTTA),
            new ItemPriced(1, Material.CYAN_TERRACOTTA),
            new ItemPriced(1, Material.PURPLE_TERRACOTTA),
            new ItemPriced(1, Material.BLUE_TERRACOTTA),
            new ItemPriced(1, Material.BROWN_TERRACOTTA),
            new ItemPriced(1, Material.GREEN_TERRACOTTA),
            new ItemPriced(1, Material.RED_TERRACOTTA),
            new ItemPriced(1, Material.BLACK_TERRACOTTA),
            new ItemPriced(1, Material.TERRACOTTA),
            new ItemPriced(3, Material.PACKED_ICE),
            new ItemPriced(1, Material.WHITE_STAINED_GLASS),
            new ItemPriced(1, Material.ORANGE_STAINED_GLASS),
            new ItemPriced(1, Material.MAGENTA_STAINED_GLASS),
            new ItemPriced(1, Material.LIGHT_BLUE_STAINED_GLASS),
            new ItemPriced(1, Material.YELLOW_STAINED_GLASS),
            new ItemPriced(1, Material.LIME_STAINED_GLASS),
            new ItemPriced(1, Material.PINK_STAINED_GLASS),
            new ItemPriced(1, Material.GRAY_STAINED_GLASS),
            new ItemPriced(1, Material.LIGHT_GRAY_STAINED_GLASS),
            new ItemPriced(1, Material.CYAN_STAINED_GLASS),
            new ItemPriced(1, Material.PURPLE_STAINED_GLASS),
            new ItemPriced(1, Material.BLUE_STAINED_GLASS),
            new ItemPriced(1, Material.BROWN_STAINED_GLASS),
            new ItemPriced(1, Material.GREEN_STAINED_GLASS),
            new ItemPriced(1, Material.RED_STAINED_GLASS),
            new ItemPriced(1, Material.BLACK_STAINED_GLASS),
            new ItemPriced(3, Material.PRISMARINE),
            new ItemPriced(3, Material.PRISMARINE_BRICKS),
            new ItemPriced(3, Material.DARK_PRISMARINE),
            new ItemPriced(1, Material.RED_SANDSTONE),
            new ItemPriced(1, Material.CHISELED_RED_SANDSTONE),
            new ItemPriced(1, Material.CUT_RED_SANDSTONE),
            new ItemPriced(3, Material.MAGMA_BLOCK),
            new ItemPriced(3, Material.NETHER_WART_BLOCK),
            new ItemPriced(3, Material.RED_NETHER_BRICKS),
            new ItemPriced(1, Material.WHITE_CONCRETE),
            new ItemPriced(1, Material.ORANGE_CONCRETE),
            new ItemPriced(1, Material.MAGENTA_CONCRETE),
            new ItemPriced(1, Material.LIGHT_BLUE_CONCRETE),
            new ItemPriced(1, Material.YELLOW_CONCRETE),
            new ItemPriced(1, Material.LIME_CONCRETE),
            new ItemPriced(1, Material.PINK_CONCRETE),
            new ItemPriced(1, Material.GRAY_CONCRETE),
            new ItemPriced(1, Material.LIGHT_GRAY_CONCRETE),
            new ItemPriced(1, Material.CYAN_CONCRETE),
            new ItemPriced(1, Material.PURPLE_CONCRETE),
            new ItemPriced(1, Material.BLUE_CONCRETE),
            new ItemPriced(1, Material.BROWN_CONCRETE),
            new ItemPriced(1, Material.GREEN_CONCRETE),
            new ItemPriced(1, Material.RED_CONCRETE),
            new ItemPriced(1, Material.BLACK_CONCRETE),
            new ItemPriced(1, Material.WHITE_CONCRETE_POWDER),
            new ItemPriced(1, Material.ORANGE_CONCRETE_POWDER),
            new ItemPriced(1, Material.MAGENTA_CONCRETE_POWDER),
            new ItemPriced(1, Material.LIGHT_BLUE_CONCRETE_POWDER),
            new ItemPriced(1, Material.YELLOW_CONCRETE_POWDER),
            new ItemPriced(1, Material.LIME_CONCRETE_POWDER),
            new ItemPriced(1, Material.PINK_CONCRETE_POWDER),
            new ItemPriced(1, Material.GRAY_CONCRETE_POWDER),
            new ItemPriced(1, Material.LIGHT_GRAY_CONCRETE_POWDER),
            new ItemPriced(1, Material.CYAN_CONCRETE_POWDER),
            new ItemPriced(1, Material.PURPLE_CONCRETE_POWDER),
            new ItemPriced(1, Material.BLUE_CONCRETE_POWDER),
            new ItemPriced(1, Material.BROWN_CONCRETE_POWDER),
            new ItemPriced(1, Material.GREEN_CONCRETE_POWDER),
            new ItemPriced(1, Material.RED_CONCRETE_POWDER),
            new ItemPriced(1, Material.BLACK_CONCRETE_POWDER),
            new ItemPriced(5, Material.BLUE_ICE)
    };

    ItemStack createProduct(Material material, int price){
        String coinsName = plugin.coinsName;
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN + "Price in " + coinsName + ":");
        lore.add(ChatColor.GREEN + "" + price);
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    ItemStack createItem(Material material, ArrayList<String> lore, String name){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (name != null){
            meta.setDisplayName(name);
        }
        if (lore != null){
            meta.setLore(lore);
        }
        item.setItemMeta(meta);

        return item;
    }

    public void openInv(Player p, int _productCount, int page){
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Material Market");
        int itemID = 0;
        int productCount = _productCount;

        if (productCount < 1)
            productCount = 1;

        for (ItemPriced i : itemsList){
            if (page == 0){
                if (itemID <= 35){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            if (page == 1){
                if (itemID > 35 && itemID <= 71){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            if (page == 2){
                if (itemID > 71 && itemID <= 107){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            if (page == 3){
                if (itemID > 107 && itemID <= 143){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            if (page == 4){
                if (itemID > 143 && itemID <= 179){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            if (page == 5){
                if (itemID > 179 && itemID <= 215){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            if (page == 6){
                if (itemID > 215 && itemID <= 251){
                    inv.addItem(createProduct(i.material, i.price * productCount));
                }
            }
            itemID++;
        }

        for (int i = 0; i <= 8; i++){
            if (i == 0){
                inv.setItem(i+36, createItem(Material.RED_STAINED_GLASS_PANE, null, ChatColor.RED + "- 100"));
            }
            if (i == 1){
                inv.setItem(i+36, createItem(Material.RED_STAINED_GLASS_PANE, null, ChatColor.RED + "- 10"));
            }
            if (i == 2){
                inv.setItem(i+36, createItem(Material.RED_STAINED_GLASS_PANE, null, ChatColor.RED + "- 1"));
            }
            if (i > 2 && i < 6){
                inv.setItem(i+36, createItem(Material.WHITE_STAINED_GLASS_PANE, null, ChatColor.WHITE + "Count: " + productCount));
            }
            if (i == 6){
                inv.setItem(i+36, createItem(Material.GREEN_STAINED_GLASS_PANE, null, ChatColor.GREEN + "+ 1"));
            }
            if (i == 7){
                inv.setItem(i+36, createItem(Material.GREEN_STAINED_GLASS_PANE, null, ChatColor.GREEN + "+ 10"));
            }
            if (i == 8){
                inv.setItem(i+36, createItem(Material.GREEN_STAINED_GLASS_PANE, null, ChatColor.GREEN + "+ 100"));
            }
        }

        for (int i = 0; i <= 8; i++){
            if (i <= 2){
                inv.setItem(i+45, createItem(Material.RED_STAINED_GLASS_PANE, null, ChatColor.RED + "- Page"));
            }
            if (i > 2 && i < 6){
                inv.setItem(i+45, createItem(Material.WHITE_STAINED_GLASS_PANE, null, ChatColor.WHITE + "Page: " + page));
            }
            if (i >= 6){
                inv.setItem(i+45, createItem(Material.GREEN_STAINED_GLASS_PANE, null, ChatColor.GREEN + "+ Page"));
            }
        }

        p.openInventory(inv);
    }
}
