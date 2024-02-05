package com.thedevnate.moii.network.packets;

public record ChunkPacket(int commandType, int[] data) {}
