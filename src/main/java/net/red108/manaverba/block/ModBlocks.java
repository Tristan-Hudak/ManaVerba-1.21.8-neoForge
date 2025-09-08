package net.red108.manaverba.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.red108.manaverba.ManaVerbaMod;
import net.red108.manaverba.item.ModItems;
import java.util.function.Function;


public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ManaVerbaMod.MODID);

    //all blocks

    public static final BlockRegistryObject<Block> SIGMORA_BLOCK = registerBlockWithItem(
            "sigmora_block",
            Block::new,
            BlockBehaviour.Properties.of()
    );

    //helper class and method
    public static class BlockRegistryObject<T extends Block> {
        public final DeferredBlock<T> block;
        public final DeferredItem<BlockItem> item;

        public BlockRegistryObject(DeferredBlock<T> block, DeferredItem<BlockItem> item){
            this.block = block;
            this.item = item;
        }
    }

    private static <T extends Block> BlockRegistryObject<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, T> supplier, BlockBehaviour.Properties properties) {
        DeferredBlock<T> block = ModBlocks.BLOCKS.registerBlock(name, supplier, properties);
        DeferredItem<BlockItem> item = ModItems.ITEMS.registerItem(name, props -> new BlockItem(block.get(), props), new Item.Properties());
        return new BlockRegistryObject<>(block, item);
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}

