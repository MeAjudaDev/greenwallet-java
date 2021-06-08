package ml.meajudadev.api.v1.controllers;

import ml.meajudadev.api.v1.dto.ExpenseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpensesController {
    private final List<ExpenseDto> expenses;

    public ExpensesController() {
        expenses = new ArrayList<>();
    }

    @GetMapping
    public List<ExpenseDto> getExpenses(
            @RequestParam(value = "start_date", required = false) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) LocalDate endDate,
            @RequestParam(value = "category", required = false) Integer category
    ) {
        return expenses
                .stream()
                .filter(expense -> category == null || expense.categoryId().equals(category))
                .filter(expense -> startDate == null || expense.dueDate().isEqual(startDate) || expense.dueDate().isAfter(startDate))
                .filter(expense -> endDate == null || expense.dueDate().isEqual(endDate) || expense.dueDate().isBefore(endDate))
                .collect(Collectors.toList());
    }

    @PostMapping
    public void newExpense(@RequestBody ExpenseDto expense) {
        expenses.add(expense);
    }

    @GetMapping("/{id}")
    public ExpenseDto getExpenseById(@PathVariable int id) {
        List<ExpenseDto> result = expenses.stream().filter(expense -> {
            return expense.id() == id;
        }).collect(Collectors.toList());

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return result.get(0);
    }

    @PutMapping("/{id}")
    public void editExpense(@PathVariable int id, @RequestBody ExpenseDto expense) {
        List<ExpenseDto> result = expenses.stream().filter(e -> e.id() == id).collect(Collectors.toList());

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        int index = expenses.indexOf(result.get(0));
        expenses.set(index, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable int id) {
        List<ExpenseDto> result = expenses.stream().filter(expense -> {
            return expense.id() == id;
        }).collect(Collectors.toList());

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        expenses.remove(result.get(0));
    }
}
