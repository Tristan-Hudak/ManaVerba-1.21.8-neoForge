package net.red108.manaverba.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.red108.manaverba.ManaVerbaMod;
import net.red108.manaverba.item.ModItems;
import java.util.function.Function;

import static net.neoforged.neoforgespi.ILaunchContext.LOGGER;
//import static com.mojang.text2speech.Narrator.LOGGER;



public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ManaVerbaMod.MODID);

    //all blocks

    public static final BlockRegistryObject<Block> SIGMORA_BLOCK = registerBlockWithItem(
            "sigmora_block",
            Block::new,
            BlockBehaviour.Properties.of().destroyTime(5.0f).explosionResistance(6.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> RAW_SIGMORA_BLOCK = registerBlockWithItem(
            "raw_sigmora_block",
            Block::new,
            BlockBehaviour.Properties.of().destroyTime(5.0f).explosionResistance(3.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> SIGMORA_ORE = registerBlockWithItem(
            "sigmora_ore",
            Block::new,
            BlockBehaviour.Properties.of().destroyTime(3.0f).explosionResistance(3.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> DEEPSLATE_SIGMORA_ORE = registerBlockWithItem(
            "deepslate_sigmora_ore",
            Block::new,
            BlockBehaviour.Properties.of().destroyTime(4.5f).explosionResistance(6.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> GLYPHITE_BLOCK = registerBlockWithItem(
            "glyphite_block",
            Block::new,
            BlockBehaviour.Properties.of().destroyTime(5.0f).explosionResistance(6.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> LONGAEVA_LOG = registerBlockWithItem(
            "longaeva_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().destroyTime(5.0f).explosionResistance(6.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> STRIPPED_LONGAEVA_LOG = registerBlockWithItem(
            "stripped_longaeva_log",
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of().destroyTime(5.0f).explosionResistance(6.0f).requiresCorrectToolForDrops()
    );
    public static final BlockRegistryObject<Block> LONGAEVA_LEAVES = registerBlockWithItem(
            "longaeva_leaves",
            LongaevaLeavesBlock::new,
            BlockBehaviour.Properties.of()
                    .destroyTime(5.0f)
                    .explosionResistance(6.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .isSuffocating(((state, level, pos) -> false))
                    .isViewBlocking(((state, level, pos) -> false))
                    .sound(SoundType.GRASS)
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
        LOGGER.debug("Registering block: {}", name);
        return new BlockRegistryObject<>(block, item);
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}

