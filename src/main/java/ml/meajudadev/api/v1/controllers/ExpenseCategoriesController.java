package ml.meajudadev.api.v1.controllers;

import ml.meajudadev.api.repositories.CategoriesRepository;
import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseCategoriesController {
    @Autowired
    CategoriesRepository categoriesRepository;

    @PostMapping("/api/v1/expense-categories")
    public void newExpenseCategory(@RequestBody ExpenseCategoryDto expenseCategoryDto) {
        categoriesRepository.createNew(expenseCategoryDto);
    }

    @GetMapping("/api/v1/expense-categories")
    public List<ExpenseCategoryDto> listCategories() throws SQLException {
        List<ExpenseCategoryDto> result = categoriesRepository.listAll();
        return result;
    }

    @GetMapping("/api/v1/expense-categories/{id}")
    public ExpenseCategoryDto findCategoryById(@PathVariable int id) {
        Optional<ExpenseCategoryDto> result = categoriesRepository.getById(id);
        return result.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/api/v1/expense-categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        Optional<ExpenseCategoryDto> query = categoriesRepository.getById(id);
        if (query.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        categoriesRepository.deleteById(id);
    }

    @PutMapping("/api/v1/expense-categories/{id}")
    public ExpenseCategoryDto updateCategory(@PathVariable long id, @RequestBody ExpenseCategoryDto newValues) {
        Optional<ExpenseCategoryDto> query = categoriesRepository.getById(id);

        if (query.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        var category = new ExpenseCategoryDto(
            id,
            newValues.userId(),
            newValues.name(),
            newValues.enabled(),
            newValues.type()
        );

        categoriesRepository.update(category);

        return category;
    }
}
