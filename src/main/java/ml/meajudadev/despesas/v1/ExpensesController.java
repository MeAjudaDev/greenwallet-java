package ml.meajudadev.despesas.v1;

import ml.meajudadev.despesas.v1.model.ExpenseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpensesController {
    private List<ExpenseModel> expenses;

    public ExpensesController() {
        expenses = new ArrayList<>();
    }

    @PostMapping("/api/v1/expenses")
    public void newExpense(@RequestBody ExpenseModel expense) {
        expenses.add(expense);
    }

    @GetMapping("/api/v1/expenses")
    public List<ExpenseModel> listExpenses() {
        return expenses;
    }

    @GetMapping("/api/v1/expenses/{id}")
    public ExpenseModel getExpenseById(@PathVariable int id) {
        List<ExpenseModel> result = expenses.stream().filter(expense -> {
            return expense.id() == id;
        }).collect(Collectors.toList());

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return result.get(0);
    }

    @PutMapping("/api/v1/expenses/{id}")
    public void editExpense(@PathVariable int id, @RequestBody ExpenseModel expense) {
        List<ExpenseModel> result = expenses.stream().filter(e -> e.id() == id).collect(Collectors.toList());

        if (result.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        int index = expenses.indexOf(result.get(0));
        expenses.set(index, expense);
    }
}
