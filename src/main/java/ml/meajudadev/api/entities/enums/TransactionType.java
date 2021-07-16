package ml.meajudadev.api.entities.enums;

public enum TransactionType {
    EXPENSE('E'),
    REVENUE('R');

    public final char label;

    TransactionType(char label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }

    public static TransactionType of(char label) {
        return switch (label) {
            case 'E' -> TransactionType.EXPENSE;
            case 'R' -> TransactionType.REVENUE;
            default -> throw new IllegalArgumentException();
        };
    }
}
