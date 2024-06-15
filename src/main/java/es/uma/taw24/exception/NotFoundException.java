package es.uma.taw24.exception;

/**
 * @author Ignacy Borzestowski: 100%
 */

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
