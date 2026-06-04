package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndLightGetter;
import net.minecraft.world.level.LevelReader;

@Mixin(LevelReader.class)
public abstract interface LevelReaderMixin extends BlockAndLightGetter {
    @Overwrite
    default int getMaxLocalRawBrightness(final BlockPos pos, final int skyDarkening) {
        return this.getRawBrightness(pos, skyDarkening);
    }
}
