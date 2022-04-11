package net.gahvila.hub.Commands.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void ChatFormat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.getPlayer().hasPermission("prefix.owner")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§d§lOmistaja §d%s §e§l>§r %s");
        } else if (p.getPlayer().hasPermission("prefix.admin")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§c§lYlläpitäjä §c%s §e§l>§r %s");
        } else if (p.getPlayer().hasPermission("prefix.valvoja")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§2§lValvoja §2%s §e§l>§r %s");
        } else if (p.getPlayer().hasPermission("prefix.rakentaja")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§a§lRakentaja §a%s §e§l>§r %s");
        }else if (p.getPlayer().hasPermission("prefix.harjoittelija")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§3§lHarjoittelija §3%s §e§l>§r %s");
        } else if (p.getPlayer().hasPermission("prefix.pro")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§5§lPro §5%s §e§l>§r %s");
        } else if (p.getPlayer().hasPermission("prefix.mvp")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
            e.setFormat("§6§lMVP §r%s §e§l>§r %s");
        } else if (p.getPlayer().hasPermission("prefix.vip")) {
            e.setFormat("§e§lVIP §r%s §e§l>§r %s");
        } else {
            e.setFormat("§b§lPelaaja §7%s §e§l>§r %s");
        }
    }
}
