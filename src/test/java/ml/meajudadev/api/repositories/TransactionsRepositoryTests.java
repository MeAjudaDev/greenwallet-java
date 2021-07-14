package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TransactionsRepositoryTests {
    @Autowired
    TransactionsRepository repository;

    @Test
    @DisplayName("can create a new transaction")
    public void givenNewTransaction_thenItCanBeSaved() {
        Transaction transaction = new Transaction();
        transaction.setCategoryId(1L);
        transaction.setUserId(1L);
        transaction.setDescription("Curso de JavaScript");
        transaction.setFixed(false);
        transaction.setState(TransactionState.ACTIVE);
        transaction.setType(TransactionType.EXPENSE);
        transaction.setValue(50D);
        transaction.setDueDate(LocalDate.of(2021, Month.JULY, 10));

        repository.save(transaction);

        assertEquals(3L, transaction.getId());
        assertEquals(1L, transaction.getCategoryId());
        assertEquals(1L, transaction.getUserId());
        assertEquals("Curso de JavaScript", transaction.getDescription());
        assertFalse(transaction.isFixed());
        assertEquals(TransactionState.ACTIVE, transaction.getState());
        assertEquals(TransactionType.EXPENSE, transaction.getType());
        assertEquals(50D, transaction.getValue());
        assertEquals(LocalDate.of(2021, Month.JULY, 10), transaction.getDueDate());
        assertNotNull(transaction.getCreatedAt());
        assertNotNull(transaction.getUpdatedAt());

        Transaction savedTransaction = repository.getById(transaction.getId());

        assertEquals(transaction.getId(), savedTransaction.getId());
        assertEquals(transaction.getCategoryId(), savedTransaction.getCategoryId());
        assertEquals(transaction.getUserId(), savedTransaction.getUserId());
        assertEquals(transaction.getDescription(), savedTransaction.getDescription());
        assertFalse(savedTransaction.isFixed());
        assertEquals(transaction.getState(), savedTransaction.getState());
        assertEquals(transaction.getType(), savedTransaction.getType());
        assertEquals(transaction.getValue(), savedTransaction.getValue());
        assertEquals(transaction.getDueDate(), savedTransaction.getDueDate());
        assertNotNull(savedTransaction.getCreatedAt());
        assertNotNull(savedTransaction.getUpdatedAt());
    }
}
