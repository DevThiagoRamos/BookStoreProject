package br.com.project.bookstore.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    private  static final long serialVersionUID = 1l;

    public DataIntegrityViolationException(String message) {
        super(message);
    }
    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
