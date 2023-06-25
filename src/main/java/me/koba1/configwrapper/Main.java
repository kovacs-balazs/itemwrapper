package me.koba1.configwrapper;

import me.koba1.configwrapper.utils.ConfigItem;
import me.koba1.configwrapper.utils.ConfigReader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public final class Main extends JavaPlugin {

    private ConfigReader configReader;
    private ConfigItem configItem;
    @Override
    public void onEnable() {
        // Plugin startup logic
        configReader = new ConfigReader();
        configItem = new ConfigItem();

        saveResource("config.yml", false);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("giveitem")) {
            Player p = (Player) sender;
            p.getInventory().addItem(configItem.getItem(configReader.getMap(args[0],  getConfig(), getConfig().getConfigurationSection(args[0]))));
        }
        return false;
    }
}
