package store.exceptions;

public class StockNotAvailableException extends Exception{

    public StockNotAvailableException(String message) {
        super(message);
    }
}
