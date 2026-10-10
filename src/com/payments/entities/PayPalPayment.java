package com.payments.entities;

import com.payments.enums.PaymentStatus;
import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;
import com.payments.interfaces.Refundable;

//Implementa Refundable porque permite reembolsos.
public class PayPalPayment extends Payment implements Refundable {
    private String email;
    private double balance;

    public PayPalPayment(String id, double amount, String email, double balance) throws InvalidPaymentException {
        super(id, amount);
        if (email == null || !email.contains("@")) {
            throw new InvalidPaymentException("El correo electrónico de PayPal es inválido.");
        }
        this.email = email;
        this.balance = balance;
    }

    @Override
    public void processPayment() throws InsufficientFundsException {
        if (amount <= balance) {
            status = PaymentStatus.APPROVED;
            balance -= amount;
        } else {
            status = PaymentStatus.REJECTED;
            throw new InsufficientFundsException("Saldo insuficiente en PayPal.");
        }

    }

    @Override
    public void refund(){
        balance += amount;
        status = PaymentStatus.PENDING;
        System.out.println("Reembolso realizado en PayPal.");
    }


    @Override
    public String toString() {
        return super.toString() + String.format(" | [PayPal] Email: %s | Saldo Restante: $%.2f", email, balance);
    }
}
