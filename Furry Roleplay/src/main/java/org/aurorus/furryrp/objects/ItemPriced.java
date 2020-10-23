package org.aurorus.furryrp.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemPriced implements Serializable {
    public String type;
    public int price;
    public String name;
    public Material material;
    public int count;
    public ArrayList<String> lore;
    public int modeldata;
    public String nameColor;
    public static ArrayList<ItemPriced> items = new ArrayList<>();

    public ItemPriced() {

    }

    public ItemPriced(String type, int price, String name, Material material, int count, ArrayList<String> lore, int modeldata, String nameColor){
        this.type = type;
        this.price = price;
        this.name = name;
        this.material = material;
        this.count = count;
        this.lore = lore;
        this.modeldata = modeldata;
        this.nameColor = nameColor;
    }
}
