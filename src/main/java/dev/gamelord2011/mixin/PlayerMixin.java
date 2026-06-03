package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.world.entity.player.Player;

@Mixin(Player.class)
public class PlayerMixin {
    @ModifyVariable(
        method = "tick",
        at = @At("STORE"),
        ordinal = 0
    )
    int maxPositionOffset(int maxPositionOffset) {
        return Integer.MAX_VALUE;
    }

    @ModifyVariable(
        method = "tick",
        at = @At("STORE"),
        ordinal = 0
    )
    double nx(double nx) {
        return nx;
    }

    @ModifyVariable(
        method = "tick",
        at = @At("STORE"),
        ordinal = 1
    )
    double nz(double nz) {
        return nz;
    }
}
