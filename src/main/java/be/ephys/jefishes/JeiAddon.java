package be.ephys.jefishes;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JeiAddon implements IModPlugin {

  public static final String FISHING_CATEGORY_UID = JustEnoughFishes.MODID + ".fishing";

  @Override
  public void register(IModRegistry registry) {
    registry.handleRecipes(JeiFishingEntry.class, JeiFishingRecipe::new, FISHING_CATEGORY_UID);

    List<JeiFishingEntry> fishingEntries = new ArrayList<>();
    fishingEntries.add(new JeiFishingEntry(LootTableList.GAMEPLAY_FISHING));
    fishingEntries.add(new JeiFishingEntry(LootTableList.GAMEPLAY_FISHING_JUNK));
    fishingEntries.add(new JeiFishingEntry(LootTableList.GAMEPLAY_FISHING_TREASURE));
    fishingEntries.add(new JeiFishingEntry(LootTableList.GAMEPLAY_FISHING_FISH));

    registry.addRecipes(
      fishingEntries.stream().map(JeiFishingRecipe::new).collect(Collectors.toList()),
      FISHING_CATEGORY_UID
    );

    // registry.handleRecipes(RecipeElvenTrade.class, ElvenTradeRecipeWrapper::new, ElvenTradeRecipeCategory.UID);
    // registry.addRecipes(BotaniaAPI.elvenTradeRecipes, ElvenTradeRecipeCategory.UID);
    // registry.addRecipeCatalyst(new ItemStack(ModBlocks.alfPortal), ElvenTradeRecipeCategory.UID);

    // LootTableList.GAMEPLAY_FISHING;
    // LootTableList.GAMEPLAY_FISHING_JUNK;
    // LootTableList.GAMEPLAY_FISHING_FISH;
    // LootTableList.GAMEPLAY_FISHING_TREASURE;

    // public static final net.minecraft.util.ResourceLocation GAMEPLAY_FISHING;
    // public static final net.minecraft.util.ResourceLocation GAMEPLAY_FISHING_JUNK;
    // public static final net.minecraft.util.ResourceLocation GAMEPLAY_FISHING_TREASURE;
    // public static final net.minecraft.util.ResourceLocation GAMEPLAY_FISHING_FISH;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registry) {
    registry.addRecipeCategories(new JeiCategoryFishing(registry.getJeiHelpers().getGuiHelper()));
  }
}
