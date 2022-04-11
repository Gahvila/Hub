package net.gahvila.hub.Commands.Info.Shop;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ShopGui {

    public static void openGui(Player p){
        Inventory inv = Bukkit.createInventory(p, 9, "§8» §e§lKauppa");
        updateGui(p, inv);
        p.openInventory(inv);
    }
    public static void updateGui(Player player, Inventory inventory) {
        inventory.setItem(3, createItem(Material.IRON_INGOT, "§e§lVIP", Arrays.asList("§7Klikkaa saadaksesi lisätietoa.")));
        inventory.setItem(4, createItem(Material.GOLD_INGOT, "§6§lMVP", Arrays.asList("§7Klikkaa saadaksesi lisätietoa.")));
    }
    private static ItemStack createItem(Material material, String displayname, List<String> lore){
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayname);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }


}
