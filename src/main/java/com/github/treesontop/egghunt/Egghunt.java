package com.github.treesontop.egghunt;

import com.github.treesontop.egghunt.events.BlockBreak;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Egghunt extends JavaPlugin {

    private static Egghunt mainClass;

    public static Egghunt getMainClass() {
        return mainClass;
    }

    @Override
    public void onEnable() {
        mainClass = this;
        ConfigHandler.reloadConfig();
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getConsoleSender().sendMessage("§aMade by Tree#9562 https://treesontop.tk/bread");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
