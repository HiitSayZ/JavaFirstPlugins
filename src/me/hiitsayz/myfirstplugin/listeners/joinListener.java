package me.hiitsayz.myfirstplugin.listeners;

import me.hiitsayz.myfirstplugin.MyFirstPlugin;
import me.hiitsayz.myfirstplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinListener implements Listener {
    private static MyFirstPlugin plugin;

    public joinListener(MyFirstPlugin plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);

        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage(
                    Utils.chat(plugin.getConfig().getString("firstJoin_message").replace("<player>", p.getName())));
        }
        else {
            Bukkit.broadcastMessage(
                    Utils.chat(plugin.getConfig().getString("join_message").replace("<player>", p.getName())));
            }
        }
    }
