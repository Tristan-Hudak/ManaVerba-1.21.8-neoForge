package net.red108.manaverba.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.red108.manaverba.ManaVerbaMod;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ManaVerbaMod.MODID);

    public static final DeferredItem<Item> LONGAEVA_BRANCH =  ITEMS.registerItem(
            "longaeva_branch",
            Item::new,
            new Item.Properties()
    );
    public static final DeferredItem<Item> GLYPHITE_CRYSTAL =  ITEMS.registerItem(
            "glyphite_crystal",
            Item::new,
            new Item.Properties()
    );
    public static final DeferredItem<Item> RAW_SIGMORA =  ITEMS.registerItem(
            "raw_sigmora",
            Item::new,
            new Item.Properties()
    );
    public static final DeferredItem<Item> SIGMORA =  ITEMS.registerItem(
            "sigmora",
            Item::new,
            new Item.Properties()
    );
    public static final DeferredItem<Item> LIQUID_SIGMORA =  ITEMS.registerItem(
            "liquid_sigmora",
            Item::new,
            new Item.Properties()
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
