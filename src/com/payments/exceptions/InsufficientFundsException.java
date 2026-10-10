package com.payments.exceptions;

// clase para fondos insuficientes
public class InsufficientFundsException extends Exception {

    // ============ CONSTRUCTOR ============
    public InsufficientFundsException(String mensaje) {
        super(mensaje);
    }// super(mensaje) llama al constructor de la clase Exception, para que el mensaje se guarde y pueda mostrarse
}


