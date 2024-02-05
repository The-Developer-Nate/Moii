package com.thedevnate.moii.network;

import com.thedevnate.moii.network.packets.ChunkPacket;
import io.wispforest.owo.network.ServerAccess;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class PacketHandler {
    public static void processChunkPacket(ChunkPacket msg, ServerAccess access) {
        ServerWorld world = access.player().getServerWorld();
        Chunk chunk = world.getChunk(access.player().getBlockPos());
        BlockPos startPos = chunk.getPos().getStartPos();
        BlockBox range = new BlockBox(startPos.getX(),world.getBottomY(),startPos.getZ(),startPos.getX()+15,world.getTopY(),startPos.getZ()+15);
        switch (msg.commandType()) {
            case 1:
                for (BlockPos blockPos : BlockPos.iterate(range.getMinX(), range.getMinY(), range.getMinZ(), range.getMaxX(), range.getMaxY(), range.getMaxZ())) {
                    world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                }
                break;
            case 2:
                for (BlockPos blockPos : BlockPos.iterate(range.getMinX(), range.getMinY(), range.getMinZ(), range.getMaxX(), range.getMaxY(), range.getMaxZ())) {
                    world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
                }
                for (BlockPos blockPos : BlockPos.iterate(range.getMinX(), range.getMinY(), range.getMinZ(), range.getMaxX(), 4, range.getMaxZ())) {
                    world.setBlockState(blockPos, Blocks.STONE.getDefaultState());
                }
                break;
            default:
                break;
        }
    }


}
