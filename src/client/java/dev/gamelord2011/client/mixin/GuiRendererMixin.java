package dev.gamelord2011.client.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.entity.Entity;

@Mixin(Gui.class)
public class GuiRendererMixin {
    @Inject(
        method = "extractVignette",
        at = @At("HEAD"),
        cancellable = true
    )
    public void extractVignette(final GuiGraphicsExtractor graphics, final @Nullable Entity camera, CallbackInfo ci) {
        ci.cancel();
    }
}
