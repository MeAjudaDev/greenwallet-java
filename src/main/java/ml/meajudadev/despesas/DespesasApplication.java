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
				new ExpenseCategory(1, "Alimentação", true),
				new ExpenseCategory(2, "Saúde", true),
				new ExpenseCategory(3, "Entretenimento", true),
				new ExpenseCategory(4, "Educação", true)
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
//{
//    "categories": [{
//        "id": 1,
//        "name": "Alimentação",
//        "state": "A",
//		  "type": "E",
//		  "user_id": 1
//    }, {
//        "id": 2,
//        "description": "Saúde",
//        "enabled": true
//    }, {
//        "id": 3,
//        "description": "Entretenimento",
//        "enabled": true
//    }, {
//        "id": 4,
//        "description": "Educação",
//        "enabled": true
//    }]
//}