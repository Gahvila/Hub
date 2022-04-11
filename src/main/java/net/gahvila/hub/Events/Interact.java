package net.gahvila.hub.Events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.gahvila.hub.Hub;
import net.gahvila.hub.Serverselector.SSGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.geysermc.cumulus.Form;
import org.geysermc.cumulus.ModalForm;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.ModalFormResponse;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

public class Interact implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getItem() == null) return;
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals("§8> §6§lValitse pelimuoto §8<")) {
                if (!FloodgateApi.getInstance().isFloodgatePlayer(p.getUniqueId())) {
                    SSGui.openGui(p);
                } else {
                    SSGui.bedrockGui(p);
                }
            }
            if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals("§8> §6§lMusiikki §8<")) {
                p.performCommand("music");
            }

            if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals("§8> §6§lSpawn §8<")) {
                p.performCommand("spawn");
            }
        }
    }
}