package ml.meajudadev.api.repositories;

import ml.meajudadev.api.entities.Transaction;
import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class TransactionsRepositoryTests {
    @Autowired
    TransactionsRepository repository;

    @Test
    @DisplayName("can create a new transaction")
    public void givenNewTransaction_thenItCanBeSavedAndRetrieved() {
        Transaction transaction = new Transaction()
                .setCategoryId(1L)
                .setUserId(1L)
                .setDescription("Curso de JavaScript")
                .setFixed(false)
                .setState(TransactionState.ACTIVE)
                .setType(TransactionType.EXPENSE)
                .setValue(BigDecimal.valueOf(500d))
                .setDueDate(LocalDate.of(2021, Month.JULY, 10));

        repository.save(transaction);

        assertEquals(3L, transaction.getId());
        assertEquals(1L, transaction.getCategoryId());
        assertEquals(1L, transaction.getUserId());
        assertEquals("Curso de JavaScript", transaction.getDescription());
        assertFalse(transaction.isFixed());
        assertEquals(TransactionState.ACTIVE, transaction.getState());
        assertEquals(TransactionType.EXPENSE, transaction.getType());
        assertEquals(BigDecimal.valueOf(500d), transaction.getValue());
        assertEquals(LocalDate.of(2021, Month.JULY, 10), transaction.getDueDate());
        assertNotNull(transaction.getCreatedAt());
        assertNull(transaction.getLastUpdatedAt());

        Optional<Transaction> query = repository.getById(transaction.getId());

        assertTrue(query.isPresent());

        Transaction savedTransaction = query.get();

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
        assertNull(savedTransaction.getLastUpdatedAt());
    }
}
