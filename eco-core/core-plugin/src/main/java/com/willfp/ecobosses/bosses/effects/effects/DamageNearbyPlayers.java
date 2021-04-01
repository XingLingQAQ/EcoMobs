package com.willfp.ecobosses.bosses.effects.effects;

import com.willfp.ecobosses.bosses.EcoBoss;
import com.willfp.ecobosses.bosses.effects.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DamageNearbyPlayers extends Effect {
    private final int frequency;
    private final double damage;
    private final double radius;
    private final boolean triggerHandler;

    public DamageNearbyPlayers(@NotNull final List<String> args) {
        super(args);

        if (args.size() < 4) {
            showConfigError("Incorrect amount of arguments!");
        }

        frequency = Integer.parseInt(args.get(0));
        radius = Double.parseDouble(args.get(1));
        damage = Double.parseDouble(args.get(2));
        triggerHandler = Boolean.parseBoolean(args.get(3));
    }

    @Override
    public String getUsage() {
        return "damage-nearby-players:<frequency>:<damage>:<radius>:<triggerHandler>";
    }

    @Override
    public void tick(@NotNull final EcoBoss boss,
                     @NotNull final LivingEntity entity,
                     final long tick) {
        if (tick % frequency == 0) {
            for (Entity nearbyEntity : entity.getNearbyEntities(radius, radius, radius)) {
                if (nearbyEntity instanceof Player) {
                    if (triggerHandler) {
                        ((Player) nearbyEntity).damage(damage, entity);
                    } else {
                        ((Player) nearbyEntity).damage(damage);
                    }
                }
            }
        }
    }
}
