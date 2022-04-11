package net.gahvila.hub;

import net.gahvila.hub.Commands.Blocking.Plugins;
import net.gahvila.hub.Commands.Events.AntiGrefk;
import net.gahvila.hub.Commands.Events.Join;
import net.gahvila.hub.Commands.Events.Leave;
import net.gahvila.hub.Commands.Events.PlayerChatEvent;
import net.gahvila.hub.Commands.Info.Shop.ShopCMD;
import net.gahvila.hub.Commands.Spawn.SpawnCMD;
import net.gahvila.hub.Events.Interact;
import net.gahvila.hub.Events.InvClick;
import net.gahvila.hub.NPC.NPCClick;
import net.gahvila.hub.Serverselector.Commands;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hub extends JavaPlugin {
    public static Hub instance;
    private PluginManager pluginManager;
    @Override
    public void onEnable() {
        pluginManager = Bukkit.getPluginManager();
        instance = this;
        getCommand("spawn").setExecutor(new SpawnCMD());
        getCommand("plugins").setExecutor(new Plugins());
        getCommand("palvelinvalikko").setExecutor(new Commands());
        getCommand("kauppa").setExecutor(new ShopCMD());

        //EVENTS
        registerListeners(new AntiGrefk(), new Join(), new Leave(), new InvClick(), new NPCClick(), new Interact(), new PlayerChatEvent());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");


    }

    private void registerListeners(Listener...listeners){
        for(Listener listener : listeners){
            pluginManager.registerEvents(listener, this);
        }
    }
}
