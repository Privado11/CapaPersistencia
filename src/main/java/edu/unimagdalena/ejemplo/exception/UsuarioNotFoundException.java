package edu.unimagdalena.ejemplo.exception;

public class UsuarioNotFoundException extends Exception{
    public UsuarioNotFoundException() {
        super();
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
