package ltxrest.ltx.exception;

public class FileStorageException extends IllegalStateException {

    private static final long serialVersionUID = 2L;

    public FileStorageException(String detailMessage)
    {
        super(detailMessage);
    }

    public FileStorageException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FileStorageException(Throwable cause)
    {
        super(cause);
    }
}
