package net.red108.manaverba.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.red108.manaverba.ManaVerbaMod;
import net.red108.manaverba.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ManaVerbaMod.MODID);

    //all blocks

    public static final DeferredBlock<Block> SIGMORA_BLOCK = BLOCKS.register("sigmora_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()

            )
    );



    //Blocks to BlockItems
    
    private static <T extends Block> DeferredBlock<T> registerBlocks(String name, Supplier<T> blockSupplier) {
        return ModBlocks.BLOCKS.register(name, blockSupplier);
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.registerItem(name, props -> new BlockItem(block.get(), props), new Item.Properties());
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
