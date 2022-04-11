package net.gahvila.hub.Commands.Blocking;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;


public class Plugins implements CommandExecutor {

    String line = "§m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m §m ";
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(line + "\n§fLisäosat§7: ");
        for(Plugin plugin : Bukkit.getPluginManager().getPlugins()){
            sender.sendMessage("§6" + plugin);
        }
        sender.sendMessage("§f" + line);
        return true;
    }
}
