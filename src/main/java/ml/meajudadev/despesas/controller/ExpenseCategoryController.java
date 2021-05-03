package ml.meajudadev.despesas.controller;

import ml.meajudadev.despesas.dto.ExpenseCategoryDTO;
import ml.meajudadev.despesas.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/expense-categories")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryService service;

    @PutMapping(path = "{id}")
    public ResponseEntity<ExpenseCategoryDTO> update(@PathVariable long id,
                                                     @RequestBody ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategoryDTO responseDto = service.update(id, expenseCategoryDTO);

        if(responseDto == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(responseDto);
    }

}
