package me.fulcanelly.enderpearlplus;

import org.bukkit.plugin.java.JavaPlugin;

import me.fulcanelly.enderpearlplus.database.EnderPearlOwnershipDatabase;
import me.fulcanelly.enderpearlplus.listeners.PearlHitNThrowListener;

public class EnderPearlPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[ENABLED] EnderPearlPlus");
        var listener = new PearlHitNThrowListener(new EnderPearlOwnershipDatabase());
        getServer()
                .getPluginManager()
                .registerEvents(listener, this);
    }

    @Override
    public void onDisable() {

    }
}
