package ml.meajudadev.api.entities;

import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;

import java.time.LocalDate;

public class Transaction {

    private Long id;
    private String description;
    private Double value;
    private boolean isFixed;
    private LocalDate dueDate;
    private TransactionType type;
    private TransactionState state;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    private Long userId;
    private Long categoryId;

    public Transaction() {
    }

    public Transaction(
            Long id,
            String description,
            Double value,
            boolean isFixed,
            LocalDate dueDate,
            TransactionType type,
            TransactionState state,
            LocalDate createdAt,
            LocalDate updatedAt,
            Long userId,
            Long categoryId
    ) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.isFixed = isFixed;
        this.dueDate = dueDate;
        this.type = type;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionState getState() {
        return state;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updateAt) {
        this.updatedAt = updateAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
