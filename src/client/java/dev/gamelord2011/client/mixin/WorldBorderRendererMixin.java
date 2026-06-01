package dev.gamelord2011.client.mixin;

// import dev.gamelord2011.MinecraftIsInfinite;

// import java.util.OptionalDouble;
// import java.util.OptionalInt;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// import com.mojang.blaze3d.pipeline.RenderTarget;
// import com.mojang.blaze3d.systems.RenderPass;
// import com.mojang.blaze3d.systems.RenderSystem;
// import com.mojang.blaze3d.textures.GpuTextureView;

// import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldBorderRenderer;
import net.minecraft.client.renderer.state.level.WorldBorderRenderState;
import net.minecraft.world.phys.Vec3;

@Mixin(WorldBorderRenderer.class)
public class WorldBorderRendererMixin {
    @Inject(
        method = "render",
        at = @At("HEAD"),
        cancellable = true
    )
    public void render(final WorldBorderRenderState state, final Vec3 cameraPos, final double renderDistance, final double depthFar, CallbackInfo ci) {
        ci.cancel();
    }
}
