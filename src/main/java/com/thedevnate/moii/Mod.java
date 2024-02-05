package com.thedevnate.moii;

import com.thedevnate.moii.network.PacketHandler;
import com.thedevnate.moii.network.packets.ChunkPacket;
import io.wispforest.owo.network.OwoNetChannel;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Mod implements ModInitializer {

    public static final OwoNetChannel SERVER_COMMUNICATION = OwoNetChannel.create(new Identifier("moii", "server_communication"));

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        SERVER_COMMUNICATION.registerServerbound(ChunkPacket.class, PacketHandler::processChunkPacket);
    }
}
