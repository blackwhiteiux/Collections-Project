public enum ErrorMessages {
    INVALID_INPUT("Введите корректные данные."),
    EMPTY_CONTACT_BOOK("Контактная книга пуста!");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
