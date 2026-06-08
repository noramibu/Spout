package spout.gamecontent.datadriven.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import spout.gamecontent.datadriven.BuiltInSpoutMoreDataDrivenRegistries;

/**
 * Extends {@link BuiltInRegistries#bootStrap()}
 * to include the {@link BuiltInSpoutMoreDataDrivenRegistries}.
 */
@Mixin(BuiltInRegistries.class)
public abstract class IncludeSpoutBootstrapBuiltInRegistriesMixin {

    @Inject(
        method = "bootStrap",
        at = @At("HEAD")
    )
    private static void onCreateContents(CallbackInfo ci) {
        BuiltInSpoutMoreDataDrivenRegistries.bootstrap();
    }

}
