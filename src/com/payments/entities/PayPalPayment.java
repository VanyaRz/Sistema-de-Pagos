package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;
import com.payments.interfaces.Refundable;

public class PayPalPayment extends Payment implements Refundable {
    private final String email;
    private double balance;

    public PayPalPayment(int id, double amount, String email, double balance) throws InvalidPaymentException {
        super(id, amount);
        if (email == null || !email.contains("@")) {
            throw new InvalidPaymentException("El correo electrónico de PayPal es inválido.");
        }
        this.email = email;
        this.balance = balance;
    }

    @Override
    public void processPayment() throws InsufficientFundsException {
        if (getAmount() > balance) {
            setEstado(Estado.REJECTED);
            throw new InsufficientFundsException(
                    String.format("PayPal: Saldo insuficiente. Saldo actual: $%.2f | Requerido: $%.2f", balance, getAmount())
            );
        }
        balance -= getAmount();
        setEstado(Estado.APPROVED);
    }

    @Override
    public void refund() throws InvalidPaymentException {
        if (getEstado() != Estado.APPROVED) {
            throw new InvalidPaymentException("No se puede reembolsar una transacción que no fue aprobada.");
        }
        balance += getAmount();
        setEstado(Estado.REFUNDED);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | [PayPal] Email: %s | Saldo Restante: $%.2f", email, balance);
    }
}
