package me.hiitsayz.myfirstplugin.ui;

import me.hiitsayz.myfirstplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class lobbyGUI {
    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 5 * 9;

    public static void initialize(){
        inventory_name = Utils.chat("&7Game Menu");

        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory GUI (Player p){
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        Utils.createItem(inv, 5, 1, 1, "&b&lUHC", "&7The original UHC game.", "&7Do you like it?", "&7I hope so...");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv){
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&b&lUHC"))){
            p.performCommand("hello");
        }
    }
}
