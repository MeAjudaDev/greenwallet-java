package ml.meajudadev.api.v1.controllers;

import ml.meajudadev.api.v1.dto.ExpenseCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpenseCategoriesController {
    private final List<ExpenseCategoryDto> categories;

    @Autowired
    JdbcTemplate db;

    public ExpenseCategoriesController() {
        categories = new ArrayList<>();
    }

    @PostMapping("/api/v1/expense-categories")
    public void newExpenseCategory(@RequestBody ExpenseCategoryDto expenseCategoryDto) {
        categories.add(expenseCategoryDto);
    }

    @GetMapping("/api/v1/expense-categories")
    public List<ExpenseCategoryDto> listCategories() throws SQLException {
        return db.query("SELECT * FROM categories", (ResultSet r) -> {
            var categories = new ArrayList<ExpenseCategoryDto>();
            while(r.next()) {
                categories.add(new ExpenseCategoryDto(
                        r.getInt("id"),
                        r.getInt("user_id"),
                        r.getString("name"),
                        r.getBoolean("enabled"),
                        r.getString("type").toCharArray()[0]
                ));
            }
            return categories;
        });
    }

    @GetMapping("/api/v1/expense-categories/{id}")
    public ExpenseCategoryDto findCategoryById(@PathVariable int id) {
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
    public ExpenseCategoryDto updateCategory(@PathVariable int id, @RequestBody ExpenseCategoryDto expenseCategoryDto) {
        ExpenseCategoryDto previousCategory = categories.stream()
                .filter(category -> category.id() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        int i = categories.indexOf(previousCategory);
        categories.set(i, new ExpenseCategoryDto(id,
                expenseCategoryDto.userId(),
                expenseCategoryDto.name(),
                expenseCategoryDto.enabled(),
                expenseCategoryDto.type()
        ));

        return categories.get(i);
    }
}
