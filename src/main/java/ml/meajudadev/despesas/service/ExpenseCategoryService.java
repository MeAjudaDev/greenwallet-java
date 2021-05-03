package ml.meajudadev.despesas.service;

import ml.meajudadev.despesas.dto.ExpenseCategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseCategoryService {

    private final List<ExpenseCategoryDTO> categories;
    private final Logger logger = LoggerFactory.getLogger(ExpenseCategoryService.class);
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public ExpenseCategoryService() {

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

    public ExpenseCategoryDTO update(long id, ExpenseCategoryDTO expenseCategoryDTO) {
        logger.info("Updating category with id {}", id);

       for(int i = 0; i < categories.size(); i++) {
           ExpenseCategoryDTO category = categories.get(i);

           if(id == category.id()) {
               ExpenseCategoryDTO responseDto = categories.set(i, new ExpenseCategoryDTO(
                       id,
                       expenseCategoryDTO.name(),
                       expenseCategoryDTO.state(),
                       expenseCategoryDTO.type(),
                       expenseCategoryDTO.userId(),
                       sdf.format(new Date()),
                       category.createdAt()
               ));

               logger.info("Category found and updated. Returning category DTO");

               return responseDto;
           }
       }

       logger.info("Category not found.");

       return null;
    }

}
