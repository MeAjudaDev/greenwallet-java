package ml.meajudadev.api.entities.enums;

public enum TransactionType {
    EXPENSE('E'),
    REVENUE('R');

    public final char label;

    TransactionType(char label) {
        this.label = label;
    }
}
