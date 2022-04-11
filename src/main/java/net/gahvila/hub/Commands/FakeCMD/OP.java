package net.gahvila.hub.Commands.FakeCMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OP implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String pn = sender.getName();
        sender.sendMessage("Made " + pn + " a server operator\n§7§o[Server: Made " + pn + " §7§oa server operator");
        return true;
    }
}
