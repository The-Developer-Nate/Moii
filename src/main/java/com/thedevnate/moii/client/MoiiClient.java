package com.thedevnate.moii.client;

import com.thedevnate.moii.screens.ChunkScreen;
import io.wispforest.owo.Owo;
import io.wispforest.owo.client.OwoClient;
import io.wispforest.owo.client.screens.OwoScreenHandler;
import io.wispforest.owo.client.screens.ScreenUtils;
import io.wispforest.owo.config.ui.ConfigScreen;
import io.wispforest.owo.ui.core.OwoUIAdapter;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class MoiiClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("chunk")
                .executes(context -> {
                            MinecraftClient client = context.getSource().getClient();
                            client.execute(() -> client.setScreen(new ChunkScreen()));
                            return 1;
                        }
                )));
    }
}
