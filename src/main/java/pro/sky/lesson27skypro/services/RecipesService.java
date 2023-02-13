package pro.sky.lesson27skypro.services;

import pro.sky.lesson27skypro.model.Recipes;

import java.util.Collection;

public interface RecipesService {
    int AddRecipe(Recipes recipe);

    Recipes getRecipe(int id);

    Collection<Recipes> getAllRecipe();

    Recipes editRecipe(int id, Recipes recipes);

    Recipes removeRecipe(int id);
}
