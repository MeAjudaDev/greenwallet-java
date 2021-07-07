package ml.meajudadev.api.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class TransactionsRepositoryTests {
    @Autowired
    TransactionsRepository repository;

    @Test
    @DisplayName("can create a new transaction")
    public void givenNewTransaction_thenItCanBeSaved() {
    }
}
