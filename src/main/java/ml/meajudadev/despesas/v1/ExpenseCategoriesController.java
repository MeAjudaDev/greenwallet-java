package ml.meajudadev.despesas.v1;

import ml.meajudadev.despesas.ExpenseCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ExpenseCategoriesController {
    private List<ExpenseCategory> categories;

    public ExpenseCategoriesController() {
        categories = new ArrayList<ExpenseCategory>() {
            {
                add(new ExpenseCategory(1, 1, "Alimentação", 'A', 'E'));
                add(new ExpenseCategory(2, 1, "Saúde", 'A', 'E'));
                add(new ExpenseCategory(3, 1, "Entretenimento", 'A', 'E'));
                add(new ExpenseCategory(4, 1, "Educação", 'A', 'E'));
            }
        };
    }

    @GetMapping("/api/v1/expense-categories")
    public List<ExpenseCategory> listCategories() {
        return categories;
    }
}
