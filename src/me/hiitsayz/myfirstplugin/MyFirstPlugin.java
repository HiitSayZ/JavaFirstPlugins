package me.hiitsayz.myfirstplugin;

import me.hiitsayz.myfirstplugin.commands.inventoryCommand;
import me.hiitsayz.myfirstplugin.listeners.inventoryClickedListener;
import me.hiitsayz.myfirstplugin.listeners.joinListener;
import me.hiitsayz.myfirstplugin.commands.HelloCommand;
import me.hiitsayz.myfirstplugin.listeners.playerDeathListener;
import me.hiitsayz.myfirstplugin.ui.lobbyGUI;
import org.bukkit.plugin.java.JavaPlugin;

public class MyFirstPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("First plugin has been enabled.");
        saveDefaultConfig();
        new HelloCommand(this);
        new inventoryCommand(this);
        new joinListener(this);
        new playerDeathListener(this);
        new inventoryClickedListener(this);
        lobbyGUI.initialize();
    }

    @Override
    public void onDisable() {
        getLogger().info("First plugin has been disabled.");
    }
}
