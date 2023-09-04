package com.split.whydoesmyglasssoundlikethat;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
public class WDMGSLT implements ModInitializer {
    public static final Identifier SILKTOUCH_BREAK_ID = new Identifier("whydoesmyglasssoundlikethat:silktouch_glass_break");
    public static SoundEvent BLOCK_SILKTOUCH_BREAK = SoundEvent.of(SILKTOUCH_BREAK_ID);
    public static final TagKey<Block> SilkTouchGoodSound = TagKey.of(RegistryKeys.BLOCK, new Identifier("whydoesmyglasssoundlikethat", "silk_touch_good_sound"));
    @Override
    public void onInitialize() {
        System.out.println("Why Does My Glass Sound Like That has been initialized!");
        Registry.register(Registries.SOUND_EVENT, WDMGSLT.SILKTOUCH_BREAK_ID, BLOCK_SILKTOUCH_BREAK);
    }
}