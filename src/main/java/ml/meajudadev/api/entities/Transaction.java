package ml.meajudadev.api.entities;

import ml.meajudadev.api.entities.enums.TransactionState;
import ml.meajudadev.api.entities.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private long id;
    private long userId;
    private long categoryId;
    private String description;
    private BigDecimal value;
    private boolean isFixed;
    private LocalDate dueDate;
    private TransactionType type;
    private TransactionState state;
    private LocalDate createdAt;
    private LocalDate lastUpdatedAt;

    public long getId() {
        return id;
    }

    public Transaction setId(long id) {
        this.id = id;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Transaction setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public Transaction setCategoryId(long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Transaction setDescription(String description) {
        this.description = Objects.requireNonNull(description);
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Transaction setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public Transaction setFixed(boolean fixed) {
        isFixed = fixed;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Transaction setDueDate(LocalDate dueDate) {
        this.dueDate = Objects.requireNonNull(dueDate);
        return this;
    }

    public TransactionType getType() {
        return type;
    }

    public Transaction setType(TransactionType type) {
        this.type = Objects.requireNonNull(type);
        return this;
    }

    public TransactionState getState() {
        return state;
    }

    public Transaction setState(TransactionState state) {
        this.state = Objects.requireNonNull(state);
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Transaction setCreatedAt(LocalDate createdAt) {
        this.createdAt = Objects.requireNonNull(createdAt);
        return this;
    }

    public LocalDate getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public Transaction setLastUpdatedAt(LocalDate lastUpdatedAt) {
        this.lastUpdatedAt = Objects.requireNonNull(lastUpdatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return getId() == that.getId()
                && getUserId() == that.getUserId()
                && getCategoryId() == that.getCategoryId()
                && getValue().equals(that.getValue())
                && isFixed() == that.isFixed()
                && getDescription().equals(that.getDescription())
                && Objects.equals(getDueDate(), that.getDueDate())
                && getType() == that.getType()
                && getState() == that.getState()
                && getCreatedAt().equals(that.getCreatedAt())
                && getLastUpdatedAt().equals(that.getLastUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getUserId(),
                getCategoryId(),
                getDescription(),
                getValue(),
                isFixed(),
                getDueDate(),
                getType(),
                getState(),
                getCreatedAt(),
                getLastUpdatedAt()
        );
    }
}
