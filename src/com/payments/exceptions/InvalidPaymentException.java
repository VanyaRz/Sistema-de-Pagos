package com.payments.exceptions;

//clase PagoInvalido
public class InvalidPaymentException extends Exception {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
