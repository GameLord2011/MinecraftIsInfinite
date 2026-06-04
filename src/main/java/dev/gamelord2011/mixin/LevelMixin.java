package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;

@Mixin(Level.class)
public abstract class LevelMixin implements LevelAccessor, AutoCloseable {
    @Overwrite
    private static boolean isInWorldBoundsHorizontal(final BlockPos pos) {
        return true;
    }

    @Overwrite
    public int getHeight(final Heightmap.Types type, final int x, final int z) {
        int y;
        if(this.hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z))) {
            y = this.getChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)).getHeight(type, x & 15, z & 15) + 1;
        } else {
            y = this.getMinY();
        }

        return y;
    }
}
