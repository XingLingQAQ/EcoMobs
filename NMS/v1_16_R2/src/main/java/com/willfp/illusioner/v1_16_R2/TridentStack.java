package com.willfp.illusioner.v1_16_R2;

import com.willfp.illusioner.nms.api.TridentStackWrapper;
import net.minecraft.server.v1_16_R2.EntityThrownTrident;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftTrident;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;
import org.bukkit.entity.Trident;
import org.bukkit.inventory.ItemStack;

public class TridentStack implements TridentStackWrapper {
    @Override
    public ItemStack getTridentStack(Trident trident) {
        EntityThrownTrident t = ((CraftTrident) trident).getHandle();
        return CraftItemStack.asBukkitCopy(t.trident);
    }
}