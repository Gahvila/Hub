package net.gahvila.hub.Serverselector;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.gahvila.hub.Hub;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.geysermc.cumulus.Form;
import org.geysermc.cumulus.SimpleForm;
import org.geysermc.cumulus.response.SimpleFormResponse;
import org.geysermc.cumulus.util.FormBuilder;
import org.geysermc.cumulus.util.FormImage;
import org.geysermc.floodgate.api.FloodgateApi;
import org.geysermc.floodgate.api.player.FloodgatePlayer;

import java.util.Arrays;
import java.util.List;

public class SSGui {
    public static void openGui(Player p){
        Inventory inv = Bukkit.createInventory(p, 27, "§8» §9§lPalvelinvalikko" );
        updateGui(p, inv);
        p.openInventory(inv);
    }
    public static void updateGui(Player player, Inventory inventory) {
        //LASIT
        inventory.setItem(0, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(1, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(2, createItem(Material.STAINED_GLASS_PANE, (short) 11, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(6, createItem(Material.STAINED_GLASS_PANE, (short) 11, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(7, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(8, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(9, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(10, createItem(Material.STAINED_GLASS_PANE, (short) 11, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(16, createItem(Material.STAINED_GLASS_PANE, (short) 11, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(17, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(18, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(19, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blueS
        inventory.setItem(20, createItem(Material.STAINED_GLASS_PANE, (short) 11, "§r", Arrays.asList("§r"))); //blue
        inventory.setItem(24, createItem(Material.STAINED_GLASS_PANE, (short) 11, "§r", Arrays.asList("§r")));//blue
        inventory.setItem(25, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue
        inventory.setItem(26, createItem(Material.STAINED_GLASS_PANE, (short) 3,"§r", Arrays.asList("§r"))); //light blue

        //Bottom gray
        inventory.setItem(21, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray
        inventory.setItem(22, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray
        inventory.setItem(23, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray


        //Top gray
        inventory.setItem(4, createItem(Material.STAINED_GLASS_PANE, (short) 7, "§r", Arrays.asList("§r"))); //gray
        inventory.setItem(3, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray
        inventory.setItem(5, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray

        //LEFT GRAY
        inventory.setItem(11, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray

        //RIGHT GRAY
        inventory.setItem(15, createItem(Material.STAINED_GLASS_PANE, (short) 7,"§r", Arrays.asList("§r"))); //gray

        //ITEMIT
        inventory.setItem(12, createItem(Material.WORKBENCH, (short) 0, "§a§lSurvival", Arrays.asList("§7Liity klikkaamalla.")));
        inventory.setItem(14, createItem(Material.WOOL, (short) 6, "§6§lCreative", Arrays.asList("§7Liity klikkaamalla."))); //pink wool
    }
    private static ItemStack createItem(Material material, short i, String displayname, List<String> lore){
        ItemStack item = new ItemStack(material, 1, i);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayname);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }


    public static void bedrockGui(Player p){
        FloodgatePlayer floodgatePlayer = FloodgateApi.getInstance().getPlayer(p.getUniqueId());
        floodgatePlayer.sendForm(
            SimpleForm.builder()
                    .title("§9§lPalvelinvalikko")
                    .content("Valitse pelimuoto klikkaamalla")
                    .button("§a§lSurvival") // id = 0
                    .button("§6§lCreative") // id = 1
                    .responseHandler((form, responseData) -> {
                        SimpleFormResponse response = form.parseResponse(responseData);
                        ByteArrayDataOutput out = ByteStreams.newDataOutput();
                        out.writeUTF("Connect");
                        switch (response.getClickedButtonId()) {
                            case 0:
                                out.writeUTF("survival");
                                p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                                break;
                            case 1:
                                out.writeUTF("creative");
                                p.sendPluginMessage(Hub.instance, "BungeeCord", out.toByteArray());
                                break;
                        }
                    }));
    }
}