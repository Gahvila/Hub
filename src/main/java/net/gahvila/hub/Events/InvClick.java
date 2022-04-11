package net.gahvila.hub.Events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.gahvila.hub.Commands.Info.Shop.ShopGui;
import net.gahvila.hub.Hub;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        //Palvelinvalikko
        if (e.getView().getTitle().equals("§8» §9§lPalvelinvalikko")){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            int i = e.getSlot();
            switch (i) {
                case 12:
                    e.setCancelled(true);
                    out.writeUTF("survival");
                    p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                    break;
                case 14:
                    e.setCancelled(true);
                    out.writeUTF("creative");
                    p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                    break;
                default:
                    e.setCancelled(true);
                    break;
            }
        }
    }
}