package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Mixin(WorldBorder.class)
public class WorldBorderMixin {
    @ModifyReturnValue(
        method = "getDamagePerBlock",
        at = @At("RETURN")
    )
    public double getDamagePerBlock(double original) {
        return 0;
    }

    @ModifyReturnValue(
        method = "isWithinBounds(DDD)Z",
        at = @At("RETURN")
    )
    public boolean isWithinBounds(boolean original) {
        return true;
    }

    @Inject(
        method = "getCollisionShape",
        at = @At("HEAD"),
        cancellable = true
    )
    public VoxelShape getCollisionShape(CallbackInfoReturnable<VoxelShape> cir) {
        VoxelShape nope = Shapes.box(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return nope;
    }

    @ModifyReturnValue(
        method = "isInsideCloseToBorder(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;)Z",
        at = @At("RETURN")
    )
    public boolean isInsideCloseToBorder(boolean original) {
        return false;
    }

    @ModifyReturnValue(
        method = "getDistanceToBorder(DD)D",
        at = @At("RETURN")
    )
    public double getDistanceToBorder(double original) {
        return Double.POSITIVE_INFINITY;
    }
}
