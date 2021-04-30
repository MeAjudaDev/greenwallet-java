package ml.meajudadev.despesas.service;

import ml.meajudadev.despesas.dto.ExpenseCategoryDTO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseCategoryService {

    List<ExpenseCategoryDTO> categories;

    public ExpenseCategoryService(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        categories = new ArrayList<>();

        categories.add(new ExpenseCategoryDTO(
                1L,
                "Supermarket",
                "A",
                "E",
                1L,
                sdf.format(new Date()),
                sdf.format(new Date())
        ));
    }

    public ExpenseCategoryDTO update(ExpenseCategoryDTO expenseCategoryDTO) {
       for(int i = 0; i < categories.size(); i++) {
           ExpenseCategoryDTO category = categories.get(i);

           if(category.id() == expenseCategoryDTO.id()) {
               categories.set(i, expenseCategoryDTO);

               return expenseCategoryDTO;
           }
       }

       return null;
    }

}
