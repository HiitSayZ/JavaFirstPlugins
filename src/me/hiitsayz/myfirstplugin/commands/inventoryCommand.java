package me.hiitsayz.myfirstplugin.commands;

import me.hiitsayz.myfirstplugin.MyFirstPlugin;
import me.hiitsayz.myfirstplugin.ui.lobbyGUI;
import me.hiitsayz.myfirstplugin.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class inventoryCommand implements CommandExecutor {
    private MyFirstPlugin plugin;

    public inventoryCommand(MyFirstPlugin plugin){
        this.plugin = plugin;

        plugin.getCommand("gui").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (!(sender instanceof Player)){
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("consoleError")));
            return true;
        }
        Player p = (Player) sender;
        if (p.hasPermission("myfirstplugin.player")){
            p.openInventory(lobbyGUI.GUI(p));
        }
        return false;
    }




}
