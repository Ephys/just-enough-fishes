package be.ephys.jefishes;

import com.google.common.collect.ImmutableList;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;
import java.util.List;

public class JeiFishingRecipe implements IRecipeWrapper {

  private final List<ItemStack> outputs;

  public JeiFishingRecipe(JeiFishingEntry recipe) {
    ImmutableList.Builder<List<ItemStack>> builder = ImmutableList.builder();
    for(Object o : recipe.getInputs()) {
      if(o instanceof ItemStack) {
        builder.add(ImmutableList.of((ItemStack) o));
      }
      if(o instanceof String) {
        builder.add(OreDictionary.getOres((String) o));
      }
    }
    input = builder.build();
    outputs = ImmutableList.copyOf(recipe.getOutputs());
  }

  @Override
  public void getIngredients(@Nonnull IIngredients ingredients) {
    ingredients.setInputLists(VanillaTypes.ITEM, input);
    ingredients.setOutputs(VanillaTypes.ITEM, outputs);
  }
}
