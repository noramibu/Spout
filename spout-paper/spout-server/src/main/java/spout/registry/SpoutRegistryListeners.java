package spout.registry;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceKey;
import org.jspecify.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Holds listeners that are invoked just before static (also known as experimental)
 * registries are populated from resources (from data packs).
 */
public final class SpoutRegistryListeners {

    private SpoutRegistryListeners() {
        throw new UnsupportedOperationException();
    }

    private static final Map<ResourceKey<Registry<?>>, List<Consumer<WritableRegistry<?>>>> listeners = new Object2ObjectArrayMap<>();

    public static <T> void registerListener(ResourceKey<Registry<T>> registryKey, Consumer<WritableRegistry<T>> listener) {
        listeners.computeIfAbsent((ResourceKey) registryKey, _ -> new ArrayList<>(1)).add(listener);
    }

    public static void onPrePopulate(WritableRegistry<?> registry) {
        @Nullable List<Consumer<WritableRegistry<?>>> listenersForRegistry = listeners.get(registry.key());
        if (listenersForRegistry != null) {
            listenersForRegistry.forEach(consumer -> consumer.accept(registry));
        }
    }

    static {
        // Add the listeners
        // TODO
    }

}
