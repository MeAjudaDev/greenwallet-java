package ml.meajudadev.api.repositories;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriesRepositoryTests {
    @ParameterizedTest
    @MethodSource("provideCategories")
    public void givenNewCategory_thenItCanBeSaved(ExpenseCategoryDto category) {
        var repository = new CategoriesRepository();
        repository.save(category);
        Optional<ExpenseCategoryDto> savedCategoryOptional = repository.getById(category.id());

        assertTrue(savedCategoryOptional.isPresent());

        ExpenseCategoryDto savedCategory = savedCategoryOptional.get();

        assertEquals(category.id(), savedCategory.id());
        assertEquals(category.userId(), savedCategory.userId());
        assertEquals(category.name(), savedCategory.name());
        assertEquals(category.type(), savedCategory.type());
        assertEquals(category.state(), savedCategory.state());
    }

    private static Stream<Arguments> provideCategories() {
        return Stream.of(
            Arguments.of(new ExpenseCategoryDto(1, 1, "Alimentação", 'A', 'E')),
            Arguments.of(new ExpenseCategoryDto(2, 1, "Educação", 'A', 'E'))
        );
    }
}
