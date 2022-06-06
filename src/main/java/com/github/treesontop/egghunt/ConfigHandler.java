package com.github.treesontop.egghunt;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigHandler {
    private static YamlConfiguration config;

    public static File getData() {
        File file = new File(Egghunt.getMainClass().getDataFolder(), "data.yml");
        if (!file.exists()) {
            Egghunt.getMainClass().saveResource("data.yml", true);
        }
        return file;
    }

    public static void save(YamlConfiguration config) {
        try {
            config.save(new File(Egghunt.getMainClass().getDataFolder(), "data.yml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        File configFile = new File(Egghunt.getMainClass().getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            Egghunt.getMainClass().saveResource("config.yml", true);
            configFile = new File(Egghunt.getMainClass().getDataFolder(), "config.yml");
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static YamlConfiguration getConfig() {
        return config;
    }
}
