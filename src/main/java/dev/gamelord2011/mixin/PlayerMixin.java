package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@Mixin(Player.class)
public abstract class PlayerMixin extends Avatar {
    protected PlayerMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

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
        return this.getX();
    }

    @ModifyVariable(
        method = "tick",
        at = @At("STORE"),
        ordinal = 1
    )
    double nz(double nz) {
        return this.getZ();
    }
}
