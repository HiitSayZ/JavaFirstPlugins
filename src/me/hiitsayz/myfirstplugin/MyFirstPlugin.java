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
        //when plugin is enabled
        getLogger().info("First plugin has been enabled.");
        saveDefaultConfig();

        registerManager();
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        //when plugin is disabled
        getLogger().info("First plugin has been disabled.");
    }

    public void registerManager() {
        //register managers
    }
    public void registerListeners() {
        //register listeners

        new joinListener(this);
        new playerDeathListener(this);
        new inventoryClickedListener(this);
        lobbyGUI.initialize();
    }
    public void registerCommands() {
        //register commands

        new HelloCommand(this);
        new inventoryCommand(this);
    }
}
