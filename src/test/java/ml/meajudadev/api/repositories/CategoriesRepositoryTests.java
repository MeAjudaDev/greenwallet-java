package ml.meajudadev.api.repositories;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
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
            Arguments.of(new ExpenseCategoryDto(3, 1, "Alimentação", true, 'E')),
            Arguments.of(new ExpenseCategoryDto(4, 1, "Educação", true, 'E'))
        );
    }

    @Test
    public void givenAllCategories_thenTheyCanBeListed() {
        List<ExpenseCategoryDto> categories = repository.listAll();
        assertEquals(2, categories.size());
    }

    @Test
    public void givenACategory_thenItCanBeDeleted() {
        repository.deleteById(1);
        Optional<ExpenseCategoryDto> queryResult = repository.getById(1);
        assertTrue(queryResult.isPresent());
        assertFalse(queryResult.get().enabled());
    }

    @Test
    public void givenAnExistingCategory_thenItCanBeEdited() {
        var category = new ExpenseCategoryDto(
                1,
                2,
                "alimentação",
                false,
                'R'
        );

        repository.update(category);

        Optional<ExpenseCategoryDto> queryResult = repository.getById(1);

        assertEquals(2, category.userId());
        assertEquals("alimentação", category.name());
        assertFalse(category.enabled());
        assertEquals('R', category.type());
    }
}
