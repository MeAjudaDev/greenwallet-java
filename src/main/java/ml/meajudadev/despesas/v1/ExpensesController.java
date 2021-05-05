package ml.meajudadev.despesas.v1;

import ml.meajudadev.despesas.v1.model.ExpenseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ExpensesController {
    @PostMapping("/api/v1/expenses")
    public void newExpense(@RequestBody ExpenseModel expense){

    }
}
