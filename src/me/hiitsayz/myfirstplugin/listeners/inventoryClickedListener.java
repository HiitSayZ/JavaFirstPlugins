package me.hiitsayz.myfirstplugin.listeners;

import me.hiitsayz.myfirstplugin.MyFirstPlugin;
import me.hiitsayz.myfirstplugin.ui.lobbyGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class inventoryClickedListener implements Listener {
    private MyFirstPlugin plugin;

    public inventoryClickedListener(MyFirstPlugin plugin){
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        String title = e.getInventory().getTitle();
        if (title.equals(lobbyGUI.inventory_name)){
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (title.equals(lobbyGUI.inventory_name)){
                lobbyGUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }
    }
}
