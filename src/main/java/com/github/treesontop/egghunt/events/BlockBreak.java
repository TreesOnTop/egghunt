package com.github.treesontop.egghunt.events;

import com.github.treesontop.egghunt.ConfigHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public class BlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Material type = event.getBlock().getType();
        if (type == PINK_CONCRETE || type == RED_CONCRETE || type == YELLOW_CONCRETE || type == ORANGE_CONCRETE || type == LIME_CONCRETE || type == LIGHT_BLUE_CONCRETE) {
            YamlConfiguration config = ConfigHandler.getConfig();
            YamlConfiguration data = YamlConfiguration.loadConfiguration(ConfigHandler.getData());
            data.set("foundeggs", data.getInt("foundeggs") + 1);
            event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.FIREWORK);
            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(event.getPlayer().getName() + " has found " + data.getInt("foundeggs") + "/" + config.getInt("eggs") + " eggs"));
            switch (data.getInt("foundeggs")) {
                case 3:
                    event.getPlayer().getInventory().addItem(new ItemStack(FLINT_AND_STEEL, 1));
                    break;
                case 6:
                    event.getPlayer().getInventory().addItem(new ItemStack(ENDER_EYE, 1));
            }
            ConfigHandler.save(data);
        }
    }
}
