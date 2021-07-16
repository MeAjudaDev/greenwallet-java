package ml.meajudadev.api.entities.enums;

public enum TransactionState {
    ACTIVE('A'),
    DISABLED('D'),
    EXCLUDED('E');

    public final char label;

    TransactionState(char label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }

    public static TransactionState of(char label) {
        return switch (label) {
            case 'A' -> TransactionState.ACTIVE;
            case 'D' -> TransactionState.DISABLED;
            case 'E' -> TransactionState.EXCLUDED;
            default -> throw new IllegalArgumentException();
        };
    }
}
