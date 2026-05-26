package spout.server.paper.impl.packetmapping.item.builtin;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import org.jspecify.annotations.Nullable;
import spout.server.paper.impl.configuration.SpoutGlobalConfiguration;
import spout.server.paper.impl.moredatadriven.namespace.NamespaceNames;
import spout.server.paper.impl.packetmapping.item.ItemMappingHandleNMSImpl;
import spout.server.paper.impl.packetmapping.item.ItemMappingsStep;
import java.util.List;

/**
 * An {@link ItemMappingsStep} to be registered with {@link ItemMappingsImpl},
 * that can add tooltips to items.
 */
public final class AddTooltipItemMappingsStep implements ItemMappingsStep {

    @Override
    public void apply(ItemMappingHandleNMSImpl handle) {
        if (!SpoutGlobalConfiguration.get().tooltips.items.namespace) return;
        Component nameComponent = NamespaceNames.getTranslatable(handle.getOriginal().getItem().keyInItemRegistry.getNamespace())
            .withStyle(style -> style
                .withItalic(true)
                .withColor(ChatFormatting.BLUE)
            );
        ItemStack itemStack = handle.getMutable();
        @Nullable ItemLore lore = itemStack.get(DataComponents.LORE);
        if (lore == null) {
            lore = new ItemLore(List.of(nameComponent));
        } else {
            lore = lore.withLineAdded(nameComponent);
        }
        itemStack.set(DataComponents.LORE, lore);
    }

}
