package me.fulcanelly.enderpearlplus;

import org.bukkit.plugin.java.JavaPlugin;

import me.fulcanelly.enderpearlplus.config.Config;
import me.fulcanelly.enderpearlplus.database.EnderPearlOwnershipDatabase;
import me.fulcanelly.enderpearlplus.listeners.PearlHitNThrowListener;

public class EnderPearlPlus extends JavaPlugin {
    @Override
    public void onEnable() {
        getDataFolder().mkdir();

        var db = new EnderPearlOwnershipDatabase(getDataFolder().getPath());
        db.initializeTable();

        var config = new Config(this);
        config.load();

        var listener = new PearlHitNThrowListener(db, config);

        getConfig();
        getServer()
                .getPluginManager()
                .registerEvents(listener, this);

        getLogger().info("* ENABLED");

    }
}
