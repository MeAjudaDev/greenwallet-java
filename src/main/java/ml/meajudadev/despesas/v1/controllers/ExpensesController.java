package ml.meajudadev.despesas.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.meajudadev.despesas.Expense;

import javax.websocket.server.PathParam;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpensesController {

    private final List<Expense> expenses = new ArrayList<>();

    public ExpensesController() {
        expenses.add(new Expense(1, "Água", 73.21, true, "2021-04-08", Arrays.asList(1,5,3), 1));
        expenses.add(new Expense(2, "Luz", 83.00, true, "2021-04-08", Arrays.asList(5,3),1));
    }

    @GetMapping
    public List<Expense> getExpenses(
            @PathParam(value = "start_date") String startDate,
            @PathParam(value = "end_date") String endDate,
            @PathParam(value = "category") String category
    ) {
        if (category != null) {
            List<Integer> categoryIds = Arrays.stream(category.split(","))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
            return expenses
                    .stream()
                    .filter(expense -> expense.getCategoryIds().containsAll(categoryIds))
                    .collect(Collectors.toList());
        }

        return expenses;
    }
}
