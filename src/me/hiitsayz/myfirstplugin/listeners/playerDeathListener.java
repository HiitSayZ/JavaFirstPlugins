package me.hiitsayz.myfirstplugin.listeners;

import me.hiitsayz.myfirstplugin.MyFirstPlugin;
import me.hiitsayz.myfirstplugin.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class playerDeathListener implements Listener {
    private static MyFirstPlugin plugin;

    public playerDeathListener(MyFirstPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            e.setDeathMessage(null);
            Player killer = e.getEntity().getKiller();
            Player p = e.getEntity();

            killer.sendMessage(Utils.chat(plugin.getConfig().getString("killerKillMessage").replace("<player>", p.getName())));
            p.sendMessage(Utils.chat(plugin.getConfig().getString("playerDeathMessage").replace("<player>", killer.getName())));
            return;
        }
    }
}
