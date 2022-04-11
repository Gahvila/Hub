package net.gahvila.hub.Commands.Events;

import net.gahvila.hub.Hub;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class AntiPlayerFucking implements Listener {

    //Täällä estetään pelaajan servun kanssa perseily, saatanan pellejä.
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!e.getWhoClicked().hasPermission("yp.muokkaus")) {
            e.setCancelled(true);
        } else {
            if (e.getWhoClicked().getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent e) {
        Entity en = e.getEntity();
        if (!(en instanceof Player)) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;
        if (e.getAction() != (Action.PHYSICAL)) {
            if (e.getClickedBlock().getType() != Material.STONE_PLATE) {
                if (e.getClickedBlock().getType() != Material.WOOD_PLATE) {
                    if (!e.getPlayer().hasPermission("yp.muokkaus")) {
                        e.setCancelled(true);
                    } else {
                        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (!e.getPlayer().hasPermission("yp.muokkaus")) {
            e.setCancelled(true);
        } else {
            if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
            }
        }
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!e.getPlayer().hasPermission("yp.muokkaus")) {
            e.setCancelled(true);
        } else {
            if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (!e.getPlayer().hasPermission("yp.muokkaus")) {
            e.setCancelled(true);
        } else {
            if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
            }
        }
    }

    //Maailman suojaus muulta paskalta
    @EventHandler
    public void onEnBreak(BlockExplodeEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onPhysics(BlockPhysicsEvent e){
        e.setCancelled(true);
    }


    //Pelaajien suojaus vakavalta kuolemalta!
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getCause() != EntityDamageEvent.DamageCause.CUSTOM) {
                e.setCancelled(true);
                if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                    new BukkitRunnable() {
                        public void run() {
                            p.teleport(new Location(Bukkit.getWorld("hub"), 1.50, 119.100, 47.500, 90f, 1.0f));
                            p.setFallDistance(0F);

                            cancel();
                        }
                    }.runTaskLater(Hub.instance, 1L);
                    p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2F, 1F);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 1));
                }
            }else{
                p.setHealth(20);

            }
        }
    }

    @EventHandler
    public void onRain(WeatherChangeEvent e){
        e.setCancelled(true);
    }
}
