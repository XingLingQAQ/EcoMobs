package com.willfp.illusioner.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlockUtils {
    private static Set<Block> getNearbyBlocks(Block start, List<Material> allowedMaterials, HashSet<Block> blocks, int limit) {
        for (BlockFace face : BlockFace.values()) {
            Block block = start.getRelative(face);
            if (!blocks.contains(block) && allowedMaterials.contains(block.getType())) {
                blocks.add(block);
                if (blocks.size() > limit) return blocks;
                if (blocks.size() > 2500) return blocks; // anti stack overflow
                blocks.addAll(getNearbyBlocks(block, allowedMaterials, blocks, limit));
            }
        }
        return blocks;
    }


    /**
     * Get a set of all blocks in contact with each other of a specific type
     *
     * @param start            The initial block
     * @param allowedMaterials A list of all valid {@link Material}s
     * @param limit            The maximum size of vein to return
     * @return A set of all {@link Block}s
     */
    public static Set<Block> getVein(Block start, List<Material> allowedMaterials, int limit) {
        return getNearbyBlocks(start, allowedMaterials, new HashSet<>(), limit);
    }
}
