package com.payments.entities;

import com.payments.enums.PaymentStatus;
import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

public class BankTransferPayment extends Payment {
    private final String accountNumber;
    private final String bankName;
    private double balance;

    public BankTransferPayment(String id, double amount, String accountNumber, String bankName, double balance)
            throws InvalidPaymentException {
        super(id, amount);
        if (accountNumber == null || accountNumber.length() < 10) {
            throw new InvalidPaymentException("El número de cuenta bancaria debe tener al menos 10 dígitos.");
        }
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }

    @Override
    public void processPayment() throws InsufficientFundsException,InvalidPaymentException{
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new InvalidPaymentException("Número de cuenta inválido.");
        }
        if (amount <= balance) {
            status = PaymentStatus.APPROVED;
            balance -= amount;
        }else{
            status = PaymentStatus.REJECTED;
            throw new InsufficientFundsException("Saldo insuficiente en la cuenta bancaria.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | [Transferencia] Banco: %s | Cuenta: %s", bankName, accountNumber);
    }
}