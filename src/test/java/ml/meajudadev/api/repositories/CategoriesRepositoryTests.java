package ml.meajudadev.api.repositories;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoriesRepositoryTests {
    @Autowired
    CategoriesRepository repository;

    @ParameterizedTest
    @MethodSource("provideCategories")
    public void givenNewCategory_thenItCanBeSaved(ExpenseCategoryDto category) {
        repository.createNew(category);
        Optional<ExpenseCategoryDto> savedCategoryOptional = repository.getById(category.id());

        assertTrue(savedCategoryOptional.isPresent());

        ExpenseCategoryDto savedCategory = savedCategoryOptional.get();

        assertEquals(category.id(), savedCategory.id());
        assertEquals(category.userId(), savedCategory.userId());
        assertEquals(category.name(), savedCategory.name());
        assertEquals(category.type(), savedCategory.type());
        assertEquals(category.enabled(), savedCategory.enabled());
    }

    private static Stream<Arguments> provideCategories() {
        return Stream.of(
            Arguments.of(new ExpenseCategoryDto(1, 1, "Alimentação", true, 'E')),
            Arguments.of(new ExpenseCategoryDto(2, 1, "Educação", true, 'E'))
        );
    }

    @Test
    public void givenAllCategories_thenTheyCanBeListed() {

    }
}
