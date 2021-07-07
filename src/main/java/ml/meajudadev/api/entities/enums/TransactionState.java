package ml.meajudadev.api.entities.enums;

public enum TransactionState {
    ACTIVE('A'),
    DISABLED('D'),
    EXCLUDED('E');

    public final char label;

    TransactionState(char label) {
        this.label = label;
    }
}
