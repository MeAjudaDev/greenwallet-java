package ml.meajudadev.despesas.v1.controllers;

import org.springframework.web.bind.annotation.*;

import ml.meajudadev.despesas.v1.dto.Expense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpensesController {

    private final List<Expense> expenses = new ArrayList<>();

    public ExpensesController() {
        expenses.add(new Expense(1, "Água", 73.21, true, LocalDate.of(2021,4,8), Arrays.asList(1,5,3), 1));
        expenses.add(new Expense(2, "Luz", 83.00, true, LocalDate.of(2021,5,12), Arrays.asList(2,4),1));
    }

    @GetMapping
    public List<Expense> getExpenses(
            @RequestParam(value = "start_date", required = false) LocalDate startDate,
            @RequestParam(value = "end_date", required = false) LocalDate endDate,
            @RequestParam(value = "category", required = false) Integer[] categories
    ) {
        return expenses
                .stream()
                .filter(expense -> categories == null || expense.categoryIds().containsAll(Arrays.asList(categories)))
                .filter(expense -> startDate == null || expense.dueDate().isEqual(startDate) || expense.dueDate().isAfter(startDate))
                .filter(expense -> endDate == null || expense.dueDate().isEqual(endDate) || expense.dueDate().isBefore(endDate))
                .collect(Collectors.toList());
    }
}
