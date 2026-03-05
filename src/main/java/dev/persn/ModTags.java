package dev.persn;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModTags {
    public static final TagKey<Block> SILK_TOUCH_ALTERED_BREAK_SOUND = TagKey.of(
        RegistryKeys.BLOCK,
        Identifier.of(WDMGSLT.MOD_ID, "silk_touch_altered_break_sound")
    );

    private ModTags() {
    }
}
