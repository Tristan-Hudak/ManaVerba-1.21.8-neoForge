package net.red108.manaverba.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.red108.manaverba.ManaVerbaMod;
import net.red108.manaverba.item.ModItems;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ManaVerbaMod.MODID);

    //all blocks

    public static final DeferredBlock<Block> SIGMORA_BLOCK = registerBlocks("sigmora_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)));



    //Blocks to BlockItems
    
    private static <T extends Block> void registerBlocks(String name, DeferredRegister<T> block) {
        DeferredRegister<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredRegister<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
