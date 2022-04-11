package net.gahvila.hub.Commands.Spawn;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawn")) {
            Player p = (Player) sender;
            p.teleport(new Location(Bukkit.getWorld("hub"), 1.50, 118.100, 47.500, 90f, 1.0f));
            //p.teleport(p.getWorld().getSpawnLocation());
            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2F, 1F);
            sender.sendMessage(ChatColor.RESET + "§fTeleporttasit spawnille.");
        }return true;
    }
}