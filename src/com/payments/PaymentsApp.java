package com.payments;

import com.payments.entities.PayPalPayment;
import com.payments.exceptions.InsufficientFundsException;

public class PaymentsApp {
    public static void main(String[] args) {

        PayPalPayment pago = new PayPalPayment(1, 100, "usuario@mail.com", 200);
        try {
            pago.processPayment(); //Si el monto es menor o igual al saldo, se aprueba.
            System.out.println("Estado del pago: " + pago.getEstado());
        } catch (InsufficientFundsException e) { //Si no, lanza la excepción InsufficientFundsException.
            System.out.println("Error: " + e.getMessage());
        }
    }
}

