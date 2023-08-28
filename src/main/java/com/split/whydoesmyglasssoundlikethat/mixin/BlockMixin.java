package com.split.whydoesmyglasssoundlikethat.mixin;

import com.split.whydoesmyglasssoundlikethat.WDMGSLT;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {

    @Overwrite
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.addBlockBreakParticles(pos, state);
        if(!world.isClient()) {
            if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, player.getMainHandStack()) == 1 && state.isIn(WDMGSLT.SilkTouchGoodSound)) {
                world.playSound((PlayerEntity) null, pos, WDMGSLT.BLOCK_SILKTOUCH_BREAK, SoundCategory.BLOCKS, 1F, 1F);
            } else {
                world.playSound((PlayerEntity) null, pos, state.getSoundGroup().getBreakSound(), SoundCategory.BLOCKS,  0.7F, 0.9F);
            }
        }
        if (state.isIn(BlockTags.GUARDED_BY_PIGLINS)) {
            PiglinBrain.onGuardedBlockInteracted(player, false);
        }
    }
}
