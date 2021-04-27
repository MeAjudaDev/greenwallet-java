package ml.meajudadev.despesas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DespesasApplication {
	private List<ExpenseCategory> categories;

	public static void main(String[] args) {
		SpringApplication.run(DespesasApplication.class, args);
	}

	public DespesasApplication() {
		categories = new ArrayList<ExpenseCategory>();
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
//{
//    "categories": [{
//        "id": 1,
//        "description": "Alimentação",
//        "enabled": true
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