package net.gahvila.hub.NPC;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.gahvila.hub.Hub;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NPCClick implements Listener {

    @EventHandler
    public void NPC(NPCRightClickEvent e) {
        int npc = e.getNPC().getId();
        Player p = e.getClicker();
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        switch (npc){
            case 0:
                out.writeUTF("survival");
                p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                break;
            case 3:
                out.writeUTF("creative");
                p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                break;

        }
    }

    @EventHandler
    public void NPC2(NPCLeftClickEvent e) {
        int npc = e.getNPC().getId();
        Player p = e.getClicker();
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        switch (npc){
            case 0:
                out.writeUTF("survival");
                p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                break;
            case 3:
                out.writeUTF("creative");
                p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                break;

        }
    }
}
