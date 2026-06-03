package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;


@Mixin(Entity.class)
public abstract class EntityMixin extends Entity {
    public EntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(
        method = "absSnapTo(DDD)V",
        at = @At("HEAD")
    )
    public void absSnapTo(final double x, final double y, final double z, CallbackInfo ci) {
        this.setPos(x, y, z);
    }
}
