package ml.meajudadev.despesas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DespesasApplication {
	private List<ExpenseCategory> categories;

	public static void main(String[] args) {
		SpringApplication.run(DespesasApplication.class, args);
	}

	public DespesasApplication() {
		categories = List.of(
				new ExpenseCategory(1, 1, "Alimentação", 'A', 'E'),
				new ExpenseCategory(2, 1, "Saúde", 'A', 'E'),
				new ExpenseCategory(3, 1, "Entretenimento", 'A', 'E'),
				new ExpenseCategory(4, 1, "Educação", 'A', 'E')
		);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/api/v1/expense-categories")
	public List<ExpenseCategory> listCategories() {
		return categories;
	}
}
