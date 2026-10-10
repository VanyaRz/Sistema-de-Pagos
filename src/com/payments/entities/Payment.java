package com.payments.entities;

import com.payments.enums.*;
import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

/**
 * Clase abstracta que representa un pago genérico.
 * Aplica ABSTRACCIÓN y HERENCIA.
 */
public abstract class Payment {
    protected String id;
    protected double amount;
    protected PaymentStatus status;

    protected Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    // Método abstracto: cada tipo de pago lo implementa diferente
    public abstract void processPayment()
            throws InsufficientFundsException, InvalidPaymentException;


    public String getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
    public PaymentStatus getStatus() {
        return status;
    }

    protected void setStatus(PaymentStatus status) {
        this.status = status;
    }


     // Representación textual del pago, usada al imprimir en consola.
    @Override
    public String toString() {
        return "Pago ID: " + id + ", Monto: " + amount + ", Estado: " + status;
    }
}