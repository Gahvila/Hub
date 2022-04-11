package net.gahvila.hub.Commands.Events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geysermc.floodgate.api.FloodgateApi;

import java.lang.reflect.Field;

public class Join implements Listener {
    String spam = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.teleport(new Location(Bukkit.getWorld("hub"), 1.50, 118.100, 47.500, 90f, 1.0f));
        p.setGameMode(GameMode.ADVENTURE);
        p.setFoodLevel(20);
        p.setHealth(20);
        e.setJoinMessage(null);
        if (!FloodgateApi.getInstance().isFloodgatePlayer(p.getUniqueId())){
            p.sendMessage(spam + "§8» §7Oletko valmiina pitämään hauskaa?\n \n §7Kauppa: §ehttps://kauppa.gahvila.net\n §7Verkkosivut: §ehttps://gahvila.net\n §7Discord: §ehttps://dc.gahvila.net\n§r §r");
        }else{
            p.sendMessage(spam + "§8» §7Oletko valmiina pitämään hauskaa?\n \n §7Kauppa: §ekauppa.gahvila.net\n §7Verkkosivut: §egahvila.net\n §7Discord: §edc.gahvila.net\n§r §r" + "\n§8» §fNimesi palvelimella on: §e" + p.getName() );
        }

        giveitems(p);
    }



    private void giveitems(Player player){

        //musiikki
        ItemStack music = new ItemStack(Material.JUKEBOX);
        ItemMeta metamusic = music.getItemMeta();
        metamusic.setDisplayName("§8> §6§lMusiikki §8<");
        music.setItemMeta(metamusic);
        player.getInventory().setItem(2, music);
        //selector
        ItemStack selector = new ItemStack(Material.COMPASS);
        ItemMeta metaselector = selector.getItemMeta();
        metaselector.setDisplayName("§8> §6§lValitse pelimuoto §8<");
        selector.setItemMeta(metaselector);
        player.getInventory().setItem(4, selector);
        //spawn tp
        //selector
        ItemStack spawn = new ItemStack(Material.NETHER_STAR);
        ItemMeta metaspawn = selector.getItemMeta();
        metaspawn.setDisplayName("§8> §6§lSpawn §8<");
        spawn.setItemMeta(metaspawn);
        player.getInventory().setItem(6, spawn);

    }

}
