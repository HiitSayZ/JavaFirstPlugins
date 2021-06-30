package me.hiitsayz.myfirstplugin.commands;

import me.hiitsayz.myfirstplugin.MyFirstPlugin;
import me.hiitsayz.myfirstplugin.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand implements CommandExecutor {
    private MyFirstPlugin plugin;

    public HelloCommand(MyFirstPlugin plugin) {
        this.plugin = plugin;
        plugin.getCommand("hello").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("consoleError")));
            return true;
        }
        Player p = (Player) sender;

        if (p.hasPermission("hello.use"))
        {
            p.sendMessage(Utils.chat(plugin.getConfig().getString("helloMessage").replace("<player>", p.getName())));
            return true;
        } else {
            p.sendMessage(Utils.chat(plugin.getConfig().getString("helloMessagePermissionFailed")));
        }
        return false;
    }
}
