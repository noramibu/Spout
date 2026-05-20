package spout.client.fabric.moredatadriven.minecraft.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import spout.common.moredatadriven.minecraft.BuiltInSpoutMoreDataDrivenRegistries;

/**
 * Extends {@link BuiltInRegistries#createContents()}
 * to include the {@link BuiltInSpoutMoreDataDrivenRegistries}.
 */
@Mixin(BuiltInRegistries.class)
public abstract class IncludeSpoutBootstrapBuiltInRegistriesMixin {

    @Inject(
        method = "createContents",
        at = @At("HEAD")
    )
    private static void onCreateContents(CallbackInfo ci) {
        BuiltInSpoutMoreDataDrivenRegistries.bootstrap();
    }

}
