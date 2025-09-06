package net.red108.manaverba.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.red108.manaverba.ManaVerbaMod;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ManaVerbaMod.MODID);

    public static final DeferredItem<Item> LONGAEVA_BRANCH =  ITEMS.register(
            "longaeva_branch", () -> new Item(new Item.Properties())
    );

    /*
    public static final DeferredItem<Item> LONGAEVA_LOG = ITEMS.register(
            "longaeva_log", () -> new Item(new Item.Properties())
    );
    */

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}
