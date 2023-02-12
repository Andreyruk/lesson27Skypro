package pro.sky.lesson27skypro.services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.lesson27skypro.model.Recipes;
import pro.sky.lesson27skypro.services.IngredientService;
import pro.sky.lesson27skypro.services.RecipesService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class RecipesServiceImpl implements RecipesService {
    private Map<Integer, Recipes> recipesMap = new HashMap<>();
    private final IngredientService ingredientService;
    @Override
    public int AddRecipe(Recipes recipe) {
        int id = recipesMap.size()+1;
        if (recipe.getIngredients() != null && !recipe.getIngredients().isEmpty()) {
            recipe.getIngredients().forEach(ingredientService::addIngredient);
        }
        recipesMap.put(id, recipe);
        return id;
    }
    @Override
    public Recipes getRecipe(int id) {
        if (!recipesMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден");
        }
        return recipesMap.get(id);
    }
    
    @Override
    public Collection<Recipes> getAllRecipe() {
        return recipesMap.values();
    }
    
    @Override
    public Recipes editRecipe(int id, Recipes recipes){
        if (!recipesMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id не найден");
        }
        return recipesMap.put(id, recipes);
    }

    @Override
    public Recipes removeRecipe(int id){
        if (!recipesMap.containsKey(id)) {
            throw new NotFoundException("Рецепт с заданным id отсутствует");
        }
        return recipesMap.remove(id);
    }
}
