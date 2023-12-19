package vitaliy.grab.doners.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.service.JdbcIngredientService;

/**
 * Oywayten 08.11.2023.
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final JdbcIngredientService jdbcIngredientService;

    public IngredientByIdConverter(JdbcIngredientService jdbcIngredientService) {
        this.jdbcIngredientService = jdbcIngredientService;
    }
    @Override
    public Ingredient convert(@NonNull String id) {
        return jdbcIngredientService.findById(id).orElse(null);
    }
}