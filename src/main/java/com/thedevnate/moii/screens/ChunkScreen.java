package com.thedevnate.moii.screens;

import com.thedevnate.moii.Mod;
import com.thedevnate.moii.network.packets.ChunkPacket;
import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import io.wispforest.owo.ui.util.CommandOpenedScreen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

public class ChunkScreen extends BaseOwoScreen<FlowLayout> implements CommandOpenedScreen {

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        rootComponent
                .surface(Surface.VANILLA_TRANSLUCENT)
                .horizontalAlignment(HorizontalAlignment.CENTER)
                .verticalAlignment(VerticalAlignment.CENTER);

        rootComponent.child(
                Containers.verticalFlow(Sizing.content() /**/, Sizing.content())
                        .child(Components.button(Text.translatable("text.moii.flatten_chunk"), button -> {
                            Mod.SERVER_COMMUNICATION.clientHandle().send(new ChunkPacket(2, new int[] {}));
                        }))
                        .padding(Insets.of(10)) //
                        .surface(Surface.PANEL)
                        .verticalAlignment(VerticalAlignment.CENTER)
                        .horizontalAlignment(HorizontalAlignment.CENTER)
        );
    }
}