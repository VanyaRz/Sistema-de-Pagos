package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

public class BankTransferPayment extends Payment {
    private final String accountNumber;
    private final String bankName;
    private double balance;

    public BankTransferPayment(int id, double amount, String accountNumber, String bankName, double balance)
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
    public void processPayment() throws InsufficientFundsException {
        if (getAmount() > balance) {
            setEstado(Estado.REJECTED);
            throw new InsufficientFundsException(
                    String.format("Transferencia bancaria fallida (%s). Saldo: $%.2f | Monto: $%.2f", bankName, balance, getAmount())
            );
        }
        balance -= getAmount();
        setEstado(Estado.APPROVED);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | [Transferencia] Banco: %s | Cuenta: %s", bankName, accountNumber);
    }
}