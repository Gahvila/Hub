package net.gahvila.hub.Commands.Info;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Discord implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(ChatColor.RESET + "§9§lGahvila §8> §fPääset Gahvilan Discord-palvelimelle osoitteesta §ehttps://dc.gahvila.net§f.");
        return true;
    }
}
