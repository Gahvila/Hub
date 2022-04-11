package net.gahvila.hub.Commands.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.getPlayer().getInventory().clear();
        e.setQuitMessage(null);
    }
}
