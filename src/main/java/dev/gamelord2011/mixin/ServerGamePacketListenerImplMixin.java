package dev.gamelord2011.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.server.network.ServerGamePacketListenerImpl;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
    @Overwrite
    private static double clampHorizontal(final double value) {
        return value;
    }

    @Overwrite
    private static boolean containsInvalidValues(final double x, final double y, final double z, final float yrot, final float xrot) {
        return false;
    }
}
