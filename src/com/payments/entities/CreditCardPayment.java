package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

public class CreditCardPayment extends Payment {
    private final String cardNumber;
    private final String cardHolder;
    private double balance;

    public CreditCardPayment(int id, double amount, String cardNumber, String cardHolder, double balance) throws InvalidPaymentException {
        super(id, amount);
        if (cardNumber == null || cardNumber.length() < 12) {
            throw new InvalidPaymentException("Número de tarjeta inválido.");
        }
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.balance = balance;
    }

    @Override
    public void processPayment() throws InsufficientFundsException {
        if (getAmount() > balance) {
            setEstado(Estado.REJECTED);
            throw new InsufficientFundsException(
                    String.format("Tarjeta de crédito: Fondos insuficientes. Saldo: $%.2f", balance)
            );
        }
        balance -= getAmount();
        setEstado(Estado.APPROVED);
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | [Tarjeta] Titular: %s", cardHolder);
    }
}
