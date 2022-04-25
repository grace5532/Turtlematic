package site.siredvin.turtlematic
import dan200.computercraft.api.ComputerCraftAPI
import dan200.computercraft.shared.turtle.upgrades.TurtleTool
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.api.ModLoadingContext
import net.minecraftforge.api.fml.event.config.ModConfigEvent
import net.minecraftforge.fml.config.ModConfig
import site.siredvin.turtlematic.common.configuration.ConfigHandler
import site.siredvin.turtlematic.common.configuration.ConfigHolder
import site.siredvin.turtlematic.common.setup.Items
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger
import site.siredvin.turtlematic.common.recipe.SoulHarvestRecipeRegistry
import site.siredvin.turtlematic.integrations.computercraft.turtle.*


@Suppress("UNUSED")
object Turtlematic: ModInitializer {
    const val MOD_ID = "turtlematic"

    var LOGGER: Logger = LogManager.getLogger(MOD_ID)

    @Suppress("MoveLambdaOutsideParentheses")
    val TAB: CreativeModeTab = FabricItemGroupBuilder.build(
        ResourceLocation(MOD_ID, "main"),
        { ItemStack(Items.AUTOMATA_CORE) }
    )

    override fun onInitialize() {
        ModConfigEvent.LOADING.register(ConfigHandler::onLoad)
        ModConfigEvent.RELOADING.register(ConfigHandler::onLoad)
        ModLoadingContext.registerConfig(MOD_ID, ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC)
        LOGGER.info(Items.AUTOMATA_CORE.descriptionId)

        SoulHarvestRecipeRegistry.injectAutomataCoreRecipes()

        ComputerCraftAPI.registerTurtleUpgrade(Automata())
        ComputerCraftAPI.registerTurtleUpgrade(EndAutomata())
        ComputerCraftAPI.registerTurtleUpgrade(HusbandryAutomata())
        ComputerCraftAPI.registerTurtleUpgrade(EnormousAutomata())
        ComputerCraftAPI.registerTurtleUpgrade(SoulScrapperTurtle())
        ComputerCraftAPI.registerTurtleUpgrade(
            TurtleTool(ResourceLocation("minecraft", "netherite_hoe"),
            net.minecraft.world.item.Items.NETHERITE_HOE, 0.0f, null)
        )
    }
}