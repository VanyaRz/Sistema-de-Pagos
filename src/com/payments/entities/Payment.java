package com.payments.entities;

import com.payments.enums.PaymentStatus;
import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

//
public abstract class Payment {

    // Identificador único del pago
    private final String id;

    // Monto del pago.
    private final double amount;

    // Estado actual del pago.
    private PaymentStatus status;

    protected Payment(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

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
        return id + " | $" + amount + " | " + status;
    }
}