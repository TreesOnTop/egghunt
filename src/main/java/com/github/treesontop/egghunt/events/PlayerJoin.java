package com.github.treesontop.egghunt.events;

import com.github.treesontop.egghunt.ConfigHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (ConfigHandler.getConfig().getBoolean("enabled")) {
            event.getPlayer().sendMessage("§aMade by Tree#9562 https://treesontop.tk/bread");
        }
    }
}
