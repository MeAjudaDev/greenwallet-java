package ml.meajudadev.api.repositories;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriesRepository {
    private List<ExpenseCategoryDto> categories;

    public CategoriesRepository() {
        categories = new ArrayList<>();
    }

    public void save(ExpenseCategoryDto category) {
        categories.add(category);
    }

    public Optional<ExpenseCategoryDto> getById(long categoryId) {
        return categories.stream().filter(x -> x.id() == categoryId).findFirst();
    }
}
