package pro.sky.lesson27skypro.services.Impl;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.lesson27skypro.model.Ingredients;
import pro.sky.lesson27skypro.services.IngredientService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private Map<Integer, Ingredients> ingredientsMap = new HashMap<>();

    @Override
    public int addIngredient(Ingredients ingredient) {
//        if (ingredientsMap.containsValue(ingredient)){
//            throw new IngredientsExistsException();
//        }
        int id = ingredientsMap.size() + 1;
        ingredientsMap.put(id, ingredient);
        return id;
    }

    @Override
    public Ingredients getIngredient(int id) {
        if (!ingredientsMap.containsKey(id)) {
            throw new NotFoundException("Ингредиент с заданным id не найден");
        }
        return ingredientsMap.get(id);
    }

    @Override
    public Collection<Ingredients> getAllIngredient() {
        return ingredientsMap.values();
    }

    @Override
    public Ingredients editIngredients(int id, Ingredients ingredient) {
        if (!ingredientsMap.containsKey(id)) {
            throw new NotFoundException("Ингредиент с заданным id не найден");
        }
        return ingredientsMap.put(id, ingredient);
    }

    @Override
    public Ingredients removeIngredients(int id) {
        if (!ingredientsMap.containsKey(id)) {
            throw new NotFoundException("Ингредиент с заданным id отсутствует");
        }
        return ingredientsMap.remove(id);
    }
}
