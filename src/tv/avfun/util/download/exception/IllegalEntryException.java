package tv.avfun.util.download.exception;


public class IllegalEntryException extends IllegalArgumentException {
    private static final long serialVersionUID = -7366175827L;

    public IllegalEntryException() {
    }

    public IllegalEntryException(String detailMessage) {
        super(detailMessage);
    }

    public IllegalEntryException(Throwable cause) {
        super(cause);
    }

    public IllegalEntryException(String message, Throwable cause) {
        super(message, cause);
    }

}
