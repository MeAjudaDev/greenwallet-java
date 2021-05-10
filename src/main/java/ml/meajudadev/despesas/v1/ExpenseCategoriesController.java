package ml.meajudadev.despesas.v1;

import ml.meajudadev.despesas.ExpenseCategory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @DeleteMapping("/api/v1/expense-categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        var filter = categories.stream().filter(category -> {
            return category.id() == id;
        }).collect(Collectors.toList());

        if(filter.size()==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        categories.remove(filter.get(0));
    }
}