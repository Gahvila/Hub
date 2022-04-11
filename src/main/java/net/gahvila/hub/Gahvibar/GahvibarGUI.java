package net.gahvila.hub.Gahvibar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class GahvibarGUI {
    public static void openGui(Player p){
        Inventory inv = Bukkit.createInventory(p, 27, "      §6§lGahvibar" );
        updateGui(p, inv);
        p.openInventory(inv);
    }
    public static void updateGui(Player player, Inventory inventory) {
        //LASIT
        inventory.setItem(0, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(1, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(2, createItem(Material.STAINED_GLASS_PANE, (short) 12, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(6, createItem(Material.STAINED_GLASS_PANE, (short) 12, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(7, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(8, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(9, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(10, createItem(Material.STAINED_GLASS_PANE, (short) 12, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(16, createItem(Material.STAINED_GLASS_PANE, (short) 12, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(17, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(18, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(19, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blueS
        inventory.setItem(20, createItem(Material.STAINED_GLASS_PANE, (short) 12, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(24, createItem(Material.STAINED_GLASS_PANE, (short) 12, "§r", Arrays.asList("§r")));//blue
        inventory.setItem(25, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(26, createItem(Material.STAINED_GLASS_PANE, (short) 12,"§r", Arrays.asList("§r"))); //light blue

        //ITEMIT
        inventory.setItem(11, createItem(Material.ENDER_CHEST, (short) 0, "§e§lLelulaatikko", Arrays.asList("§7Napsauta toki, nappi ei pure.")));
        //inventory.setItem(12, createItem(Material.GRASS, (short) 0, "§b§lJotakin", Arrays.asList("§7Lore.")));
        inventory.setItem(13, createItem(Material.WORKBENCH, (short) 0, "§a§lKauppa", Arrays.asList("§7Napsauta nähdäksesi loisto valikoiman!")));
        //inventory.setItem(14, createItem(Material.WOOL, (short) 6, "§6§lCreative", Arrays.asList("§7Liity klikkaamalla."))); //pink wool
        inventory.setItem(15, createItem(Material.IRON_AXE, (short) 0, "§", Arrays.asList("§7Liity klikkaamalla.")));
    }
    private static ItemStack createItem(Material material, short i, String displayname, List<String> lore){
        ItemStack item = new ItemStack(material, 1, i);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayname);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
