package es.uma.taw24.exception;

/**
 * @author Ignacy Borzestowski: 100%
 */

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
