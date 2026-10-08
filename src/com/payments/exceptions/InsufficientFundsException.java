package com.payments.exceptions;

public class InsufficientFundsException extends Exception {// fondos insuficientes

    // ============ CONSTRUCTOR ============
    public InsufficientFundsException(String mensaje) {
        super(mensaje);
    }// super(mensaje) llama al constructor de la clase Exception, para que el mensaje se guarde y pueda mostrarse
}


