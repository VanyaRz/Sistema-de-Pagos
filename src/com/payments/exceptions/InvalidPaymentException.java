package com.payments.exceptions;

public class InvalidPaymentException extends Exception {

    // ============ CONSTRUCTOR ============
    public InvalidPaymentException(String mensaje) {
        super(mensaje);
    }// super(mensaje) llama al constructor de la clase Exception, recibe un mensaje
     // de error
}
