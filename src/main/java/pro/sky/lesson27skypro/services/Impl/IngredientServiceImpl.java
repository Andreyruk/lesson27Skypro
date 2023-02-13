package pro.sky.lesson27skypro.services.Impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pro.sky.lesson27skypro.model.Ingredients;
import pro.sky.lesson27skypro.services.IngredientService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private Map<Integer, Ingredients> ingredientsMap = new HashMap<>();
    private static int id = 0;

    @Override
    public int addIngredient(Ingredients ingredient) {
//        if (ingredientsMap.containsValue(ingredient)){
//            throw new IngredientsExistsException();
//        }
        ingredientsMap.put(id++, ingredient);
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
