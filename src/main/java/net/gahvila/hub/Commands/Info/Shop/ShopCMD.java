package net.gahvila.hub.Commands.Info.Shop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage("Kauppa-komento tulee käyttöön pian!");
        //ShopGui.openGui((Player) sender);
        return true;
    }
}
