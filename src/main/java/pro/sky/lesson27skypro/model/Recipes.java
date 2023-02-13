package pro.sky.lesson27skypro.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Recipes {
    @NotBlank(message = "Обязательно введите имя рецепта")
    private String nameRecipe;
    @Positive
    private int cookingTime;
    @NotBlank
    private String measureUnitTime;
    @NotEmpty
    private List<Ingredients> ingredients;
    @NotEmpty
    private List<String> stepsCooking;
}
