package com.willfp.illusioner.v1_16_R2;

import com.willfp.illusioner.nms.api.BlockBreakWrapper;
import net.minecraft.server.v1_16_R2.BlockPosition;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class BlockBreak implements BlockBreakWrapper {
    @Override
    public void breakBlock(Player player, Block block) {
        ((CraftPlayer)player).getHandle().playerInteractManager.breakBlock(new BlockPosition(block.getX(), block.getY(), block.getZ()));
    }
}
