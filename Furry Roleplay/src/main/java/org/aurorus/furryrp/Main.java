package org.aurorus.furryrp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aurorus.furryrp.commands.*;
import org.aurorus.furryrp.events.*;
import org.aurorus.furryrp.libraries.SignMenuFactory;
import org.aurorus.furryrp.objects.ItemPriced;
import org.aurorus.furryrp.objects.Quest;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import skinsrestorer.bukkit.SkinsRestorer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Main extends JavaPlugin
{
    private SignMenuFactory signMenuFactory;
    File dataFile = new File(getDataFolder(), "data.json");
    File itemsFile = new File(getDataFolder(), "gifts.json");
    ObjectMapper mapper = new ObjectMapper();
    public String coinsName = "FurCoins";
    public int coinsPer30Min = 20;
    public int newPlayerCoins = 50;
    public int skinsIntegration = 0;
    public int coinsPerDay = 5;
    public boolean giftingYourself = false;

    //Config file
    void Config()
    {
        getConfig().addDefault("coins-name", "FurCoins");
        getConfig().addDefault("coins-per-30-min", 20);
        getConfig().addDefault("new-player-coins", 50);
        getConfig().addDefault("coins-per-day", 5);
        getConfig().addDefault("gifting-yourself", false);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onEnable()
    {
        //Jackson load data Items
        try
        {
            ItemPriced.items = mapper.readValue(itemsFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, ItemPriced.class));
        } catch (IOException e)
        {
            ItemPriced.items.add(new ItemPriced("Item", 10, "Cookie", Material.COOKIE, 1, null, 0, "NONE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.BLUE_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.CYAN_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.LIME_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.RED_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.WHITE_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.BLACK_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.BROWN_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.GRAY_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.GREEN_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.LIGHT_BLUE_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.LIGHT_GRAY_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.MAGENTA_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.ORANGE_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.PINK_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.PURPLE_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 100, "Squeaky Toy", Material.YELLOW_WOOL, 1, null, 0, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 10000, "Plushie", Material.TOTEM_OF_UNDYING, 1, null, 1, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 10000, "Plushie", Material.TOTEM_OF_UNDYING, 1, null, 2, "BLUE"));
            ItemPriced.items.add(new ItemPriced("Item", 10000, "Plushie", Material.TOTEM_OF_UNDYING, 1, null, 3, "BLUE"));
            ItemPriced.items.add(null);
            ItemPriced.items.add(null);
            ItemPriced.items.add(null);
            ItemPriced.items.add(null);
            ItemPriced.items.add(null);
            ItemPriced.items.add(null);
            ItemPriced.items.add(null);
        }

        this.signMenuFactory = new SignMenuFactory(this);

        if(!this.getDataFolder().exists())
        {
            this.getDataFolder().mkdir();
        }

        //Jackson save data
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                ArrayList<Sona> SonasList = Sona.SonasList;
                ArrayList<ItemPriced> items = ItemPriced.items;
                try
                {
                    mapper.writeValue(dataFile, SonasList);
                    mapper.writeValue(itemsFile, items);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }.runTaskTimer(this, 0, 200);

        final boolean[] coinsControl = {true};

        //Jackson load data
        try {
            Sona.SonasList = mapper.readValue(dataFile, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Sona.class));
        } catch (IOException e) {

        }

        Config();

        coinsName = getConfig().getString("coins-name");
        coinsPer30Min = getConfig().getInt("coins-per-30-min");
        newPlayerCoins = getConfig().getInt("new-player-coins");
        skinsIntegration = getConfig().getInt("skins-integration");
        coinsPerDay = getConfig().getInt("coins-per-day");
        giftingYourself = getConfig().getBoolean("gifting-yourself");

        new Quest().createQuests();

        new SetSona(this);
        new InfoSona(this);
        new GiveCoins(this);
        new Gift(this);
        new GiveCoords(this);
        new Pride(this);
        new Wardrobe(this);
        new Social(this);
        new LocalChat(this);
        new ManageGifts(this);
        new OpenQuest(this);
        new MaterialMarket(this);

        this.getServer().getPluginManager().registerEvents(new Join(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        this.getServer().getPluginManager().registerEvents(new BuyGift(this), this);
        this.getServer().getPluginManager().registerEvents(new ItemUse(), this);
        this.getServer().getPluginManager().registerEvents(new BuyPrideItem(this), this);
        this.getServer().getPluginManager().registerEvents(new SocialClick(this), this);
        this.getServer().getPluginManager().registerEvents(new QuestsClick(this), this);
        this.getServer().getPluginManager().registerEvents(new SetSonaClick(this), this);
        this.getServer().getPluginManager().registerEvents(new WardrobeChange(this), this);
        this.getServer().getPluginManager().registerEvents(new MaterialMarketUse(this), this);

        new BukkitRunnable()
        {
            @Override
            public void run() {
                ArrayList<Sona> SonasList = Sona.SonasList;
                if (!coinsControl[0]) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        for (Sona s : SonasList) {
                            if (s.id.equals(p.getUniqueId())) {
                                if (s.daily < coinsPerDay){
                                    s.coins += coinsPer30Min;
                                    s.daily++;
                                    p.sendMessage(ChatColor.BLUE + "You got " + coinsPer30Min + " " + coinsName + " for playing! Daily " + s.daily + "/" + coinsPerDay);
                                }
                                else{
                                    p.sendMessage(ChatColor.RED+ "You got daily coins limit! Daily " + s.daily + "/" + coinsPerDay + "\nif you want get more coins, check your /orders");
                                }
                            }
                        }
                    }
                }
                coinsControl[0] = false;
            }
        }.runTaskTimer(this, 0, 36000);

        new BukkitRunnable(){
            @Override
            public void run(){
                ArrayList<Sona> SonasList = Sona.SonasList;
                for (Sona s : SonasList){
                    s.daily = 0;
                }
                for (Player p : Bukkit.getOnlinePlayers())
                    p.sendMessage(ChatColor.GREEN + "New day, New Rewards! Good Morning");
            }
        }.runTaskTimer(this, 0, 1728000);
    }

    public SignMenuFactory getSignMenuFactory() {
        return this.signMenuFactory;
    }
}
