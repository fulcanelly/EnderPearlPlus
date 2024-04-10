package me.fulcanelly.enderpearlplus.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import com.saicone.rtag.RtagEntity;

import lombok.AllArgsConstructor;
import me.fulcanelly.enderpearlplus.config.Config;
import me.fulcanelly.enderpearlplus.database.EnderPearlOwnershipDatabase;

@AllArgsConstructor
public class PearlHitNThrowListener implements Listener {
    final EnderPearlOwnershipDatabase db;
    final Config config;

    @EventHandler
    public void onPearlLanding(ProjectileHitEvent event) {
        var oldPearl = event.getEntity();

        if (!oldPearl.getType().equals(EntityType.ENDER_PEARL)) {
            return;
        }

        var oldPearlUUID = oldPearl.getUniqueId().toString();
        var ownerName = db.getOwnerOfPerl(oldPearlUUID);

        db.removeRecord(oldPearlUUID);

        var rtag = new RtagEntity(oldPearl);
        if (rtag.<Object>get("Owner") != null) {
            return;
        }

        if (ownerName == null) {
            return;
        }

        var player = Bukkit.getPlayer(ownerName);

        if (player == null) {
            return;
        }

        var inSameWorld = player.getLocation().getWorld().equals(oldPearl.getLocation().getWorld());
        if (config.checkWorld && !inSameWorld) {
            return;
        }

        var newPearl = player.launchProjectile(EnderPearl.class);

        newPearl.setVelocity(oldPearl.getVelocity().clone());
        newPearl.teleport(oldPearl.getLocation());
        oldPearl.remove();
    }

    @EventHandler
    void onPearlLaunch(ProjectileLaunchEvent event) {
        var entity = event.getEntity();

        if (!entity.getType().equals(EntityType.ENDER_PEARL)) {
            return;
        }

        var shooter = entity.getShooter();

        if (shooter instanceof Player player) {
            db.createRecord(player.getName(), entity.getUniqueId().toString());
        }

    }

}
