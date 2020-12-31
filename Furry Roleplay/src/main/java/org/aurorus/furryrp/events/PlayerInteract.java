package org.aurorus.furryrp.events;

import org.aurorus.furryrp.Utils;
import org.aurorus.furryrp.inventories.InteractionsInv;
import org.aurorus.furryrp.objects.SelectedEntity;
import org.aurorus.furryrp.objects.Sona;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class PlayerInteract implements Listener {

    @EventHandler
    public void Interact(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Entity entity = e.getRightClicked();
        InteractionsInv inv = new InteractionsInv();
        ItemStack item = p.getInventory().getItemInMainHand();
        boolean control = true;

        if (entity.getType().equals(EntityType.PLAYER)) {
            if (item == null || item.getType().equals(Material.AIR)){
                ArrayList<SelectedEntity> selectedEntity = SelectedEntity.selectedEntity;
                Utils utils = new Utils();
                Sona s = utils.searchPlayerSona(p);
                if (s != null){
                    if (selectedEntity.size() != 0){
                        for (SelectedEntity sel : selectedEntity){
                            if (sel.id.equals(e.getPlayer().getUniqueId()))
                            {
                                sel.selected = entity;
                                control = false;
                            }
                        }
                        if (control)
                            selectedEntity.add(new SelectedEntity(e.getPlayer().getUniqueId(), entity, null));
                    }
                    else {
                        selectedEntity.add(new SelectedEntity(e.getPlayer().getUniqueId(), entity, null));
                    }

                    inv.openInv(p, (Player) entity);
                }
            }
        }
    }
    void Effect(Player p, Entity e, String interaction, String interaction2, Particle particle1, Particle particle2, int count1, int count2, Sound sound1, Sound sound2, PotionEffectType potion) {

        LivingEntity le = (LivingEntity) e;

        p.sendMessage(interaction + ChatColor.BLUE + e.getName());
        e.sendMessage(interaction2);
        if (particle1 != null)
            Bukkit.getWorld(p.getWorld().getName()).spawnParticle(particle1, p.getLocation(), count1, 3.0, 0.0, 3.0);
        if (sound1 != null)
            Bukkit.getWorld(p.getWorld().getName()).playSound(p.getLocation(), sound1, 1f, 1f);
        if (particle2 != null)
            Bukkit.getWorld(p.getWorld().getName()).spawnParticle(particle2, e.getLocation(), count2, 3.0, 0.0, 3.0);
        if (sound2 != null)
            Bukkit.getWorld(p.getWorld().getName()).playSound(e.getLocation(), sound2, 1f, 1f);
        if (potion != null)
            le.addPotionEffect(new PotionEffect(potion, 30, 0));
        p.closeInventory();
    }
    @EventHandler
    public void Options(InventoryClickEvent e) {
        String invName = e.getView().getTitle();
        Player p = (Player) e.getWhoClicked();
        String itemName = null;
        ArrayList<SelectedEntity> selectedEntity = SelectedEntity.selectedEntity;

        if (e.getCurrentItem() == null)
            return;

        Entity entity = null;
        for (SelectedEntity s : selectedEntity) {
            if (s.id.equals(p.getUniqueId())) {
                entity = s.selected;
            }
        }

        if (e.getCurrentItem().hasItemMeta()) {
            itemName = e.getCurrentItem().getItemMeta().getDisplayName();
        }

        if (invName.equals(ChatColor.GREEN + "Interact")) {
            e.setCancelled(true);
            if (itemName.equals(ChatColor.GREEN+"Hug"))
                Effect(p, entity, "You have gived some warm hugs to ", "You got hugged by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE + " Its so warm!", Particle.HEART, Particle.HEART, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Kiss"))
                Effect(p, entity, "You smooches cheek of ", "Your cheek got kissed by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, Particle.HEART, Particle.HEART, 60, 60, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, PotionEffectType.LEVITATION);
            else if (itemName.equals(ChatColor.GREEN+"Pet"))
                Effect(p, entity, "~pat pat ", "You are petted by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, Particle.HEART, Particle.HEART, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Belly Rubs"))
                Effect(p, entity, "You are rubbing belly of ", "Your belly get rubbed by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, Particle.HEART, Particle.HEART, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Lick"))
                Effect(p, entity, "You are licking ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " is licking your face", Particle.HEART, Particle.WATER_SPLASH, 30, 30, Sound.AMBIENT_UNDERWATER_ENTER, Sound.AMBIENT_UNDERWATER_ENTER, null);
            else if (itemName.equals(ChatColor.GREEN+"Scratch"))
                Effect(p, entity, "You scrathes back of ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " scrathes your back", null, Particle.CRIT, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Bite"))
                Effect(p, entity, "You are biting gently ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " bites your ear gently", null, Particle.CRIT, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Blep"))
                Effect(p, entity, "~Bleps to ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " bleps", Particle.HEART, Particle.HEART, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Ear Rubs"))
                Effect(p, entity, "You are rubbing ear of ", "Your behind of ear is rubbed by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, Particle.HEART, Particle.HEART, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Murr"))
                Effect(p, entity, "~Murrs to ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " ~Murrs happily", Particle.HEART, null, 30, 30, Sound.ENTITY_PLAYER_LEVELUP, Sound.ENTITY_PLAYER_LEVELUP, null);
            else if (itemName.equals(ChatColor.GREEN+"Wags Tail"))
                Effect(p, entity, "You are wagging tail happily to ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " wags tail and looks on your face", Particle.HEART, null, 30, 30, Sound.ENTITY_WOLF_SHAKE, Sound.ENTITY_WOLF_SHAKE, null);
            else if (itemName.equals(ChatColor.GREEN+"Boop"))
                Effect(p, entity, "You are booping nose of ", "You got booped by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, null, Particle.CRIT, 30, 30, null, Sound.BLOCK_STONE_BREAK, null);
            else if (itemName.equals(ChatColor.RED+"Slap"))
                Effect(p, entity, "You slapped ", "Your cheek got slapped by " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, Particle.VILLAGER_ANGRY, null, 30, 30, Sound.ENTITY_VILLAGER_NO, Sound.ENTITY_VILLAGER_NO, PotionEffectType.POISON);
            else if (itemName.equals(ChatColor.RED+"Wrrr"))
                Effect(p, entity, "You are growling on ", ChatColor.BLUE + p.getName() + ChatColor.WHITE + " is growling on you", Particle.VILLAGER_ANGRY, null, 30, 30, Sound.ENTITY_WOLF_GROWL, Sound.ENTITY_WOLF_GROWL, null);
            else if (itemName.equals(ChatColor.RED+"Spank"))
                Effect(p, entity, "You spanked ", "You got spank from " + ChatColor.BLUE + p.getName() + ChatColor.WHITE, Particle.VILLAGER_ANGRY, null, 30, 30, Sound.ENTITY_VILLAGER_NO, Sound.ENTITY_VILLAGER_NO, PotionEffectType.POISON);
        }
    }
}
