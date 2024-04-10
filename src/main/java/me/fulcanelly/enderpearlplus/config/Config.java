package me.fulcanelly.enderpearlplus.config;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class Config {

    private final JavaPlugin plugin;

    public boolean checkWorld;

    public void load() {
        plugin.saveDefaultConfig();
        var config = plugin.getConfig();
        checkWorld = config.getBoolean("check-world");
    }
}
