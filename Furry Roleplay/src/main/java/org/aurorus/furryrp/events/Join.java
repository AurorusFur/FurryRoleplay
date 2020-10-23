package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Main;
import org.aurorus.furryrp.objects.Quest;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Random;

public class Join implements Listener {

    private final Main plugin;

    public Join(Main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        ArrayList<Sona> SonasList = Sona.SonasList;
        Player p = e.getPlayer();
        int newPlayerCoins = plugin.newPlayerCoins;
        int valid = 1;

        if(SonasList.size() != 0){
            for (Sona s : SonasList){
                if (s.id.equals(p.getUniqueId())){
                    valid = 0;
                }
            }
            if (valid == 1){
                SonasList.add(new Sona("Unset", "Unset", "Unset", "Unset", "Unset", "Unset", "Unset", newPlayerCoins, e.getPlayer().getUniqueId(), 0, new Quest().pickQuest(), 0, 0, 0));
            }
        }
        else{
            SonasList.add(new Sona("Unset", "Unset", "Unset", "Unset", "Unset", "Unset", "Unset", newPlayerCoins, e.getPlayer().getUniqueId(), 0, new Quest().pickQuest(), 0, 0, 0));
        }
    }
}
