package com.split.whydoesmyglasssoundlikethat;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;

import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class WDMGSLT implements ModInitializer {
    public static final Identifier SILKTOUCH_BREAK_ID = new Identifier("whydoesmyglasssoundlikethat:silktouch_glass_break");
    public static SoundEvent BLOCK_SILKTOUCH_BREAK = new SoundEvent(SILKTOUCH_BREAK_ID);
    public static final Tag<Block> SilkTouchGoodSound = TagRegistry.block(new Identifier("whydoesmyglasssoundlikethat", "silk_touch_good_sound"));

    @Override
    public void onInitialize() {
        System.out.println("Why Does My Glass Sound Like That has been initialized!");
        Registry.register(Registry.SOUND_EVENT, WDMGSLT.SILKTOUCH_BREAK_ID, BLOCK_SILKTOUCH_BREAK);
    }
}