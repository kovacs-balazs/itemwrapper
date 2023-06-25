package me.koba1.configwrapper.utils;

import me.koba1.configwrapper.Main;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class ConfigReader {

    private static Main plugin;
    public ConfigReader(Main plugin) {
        this.plugin = plugin;
    }

    public HashMap<String, Object> getMap(String configName, ConfigurationSection configSection) {
        HashMap<String, Object> hashMap = baseValues();
        for (String key : configSection.getKeys(false)) {
            hashMap.put(key, plugin.getConfig().get(configName + "." + key));
        }
        return hashMap;
    }

    private HashMap<String, Object> baseValues() {
        HashMap<String, Object> map = new HashMap();
        map.put("material", Material.AIR);
        map.put("display_name", null);
        map.put("lore", new ArrayList<String>());
        map.put("amount", 1);
        map.put("data", 0);
        map.put("base64", null);
        map.put("enchantments", new ArrayList<String>());
        map.put("item_flags", new ArrayList<String>());
        map.put("custom_model_data", 0);
        map.put("unbreakable", false);
        map.put("hide_unbreakable", false);
        map.put("skull_owner", null);
        map.put("banner_meta", new ArrayList<>());
        return map;
    }
}
