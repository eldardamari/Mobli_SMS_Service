package main.java.com.mobli.interview.exception;

public class MessageTransferException extends Exception {

    public MessageTransferException(String message) {
        super(message);
    }

    public MessageTransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
