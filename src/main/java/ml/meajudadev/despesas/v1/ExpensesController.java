package ml.meajudadev.despesas.v1;

import ml.meajudadev.despesas.v1.model.ExpenseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
