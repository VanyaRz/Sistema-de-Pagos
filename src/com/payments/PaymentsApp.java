package com.payments;

import com.payments.entities.*;

public class PaymentsApp {
    public static void main(String[] args) {
        // Crear administrador de pagos
        PaymentManager manager = new PaymentManager();

        // Crear diferentes tipos de pagos
        Payment p1 = new CreditCardPayment(1, 1000, "1234-5678-9012", "Juan Perez", 5000);
        Payment p2 = new PayPalPayment(2, 850, "cliente@email.com", 1000);
        Payment p3 = new BankTransferPayment(3, 2000, "987654321", "Banco XYZ", 1500);

    }
}// class PaymentsApp

