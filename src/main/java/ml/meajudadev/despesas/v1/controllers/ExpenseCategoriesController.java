package ml.meajudadev.despesas.v1.controllers;

import ml.meajudadev.despesas.v1.model.ExpenseCategoryModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpenseCategoriesController {
    private final List<ExpenseCategoryModel> categories;

    public ExpenseCategoriesController() {
        categories = new ArrayList<>();
    }

    @PostMapping("/api/v1/expense-categories")
    public void newExpenseCategory(@RequestBody ExpenseCategoryModel expenseCategoryModel) {
        categories.add(expenseCategoryModel);
    }

    @GetMapping("/api/v1/expense-categories")
    public List<ExpenseCategoryModel> listCategories() {
        return categories;
    }

    @GetMapping("/api/v1/expense-categories/{id}")
    public ExpenseCategoryModel findCategoryById(@PathVariable int id) {
        var filter = categories.stream().filter(category -> {
            return category.id() == id;
        }).collect(Collectors.toList());

        if (filter.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return filter.get(0);
    }

    @DeleteMapping("/api/v1/expense-categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        var filter = categories.stream().filter(category -> {
            return category.id() == id;
        }).collect(Collectors.toList());

        if (filter.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        categories.remove(filter.get(0));
    }

    @PutMapping("/api/v1/expense-categories/{id}")
    public ExpenseCategoryModel updateCategory(@PathVariable int id, @RequestBody ExpenseCategoryModel expenseCategoryModel) {
        ExpenseCategoryModel previousCategory = categories.stream()
                .filter(category -> category.id() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        int i = categories.indexOf(previousCategory);
        categories.set(i, new ExpenseCategoryModel(id,
                expenseCategoryModel.userId(),
                expenseCategoryModel.name(),
                expenseCategoryModel.state(),
                expenseCategoryModel.type()
        ));

        return categories.get(i);
    }
}
