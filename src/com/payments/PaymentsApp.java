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

    // Mostrar todos los pagos registrados
        System.out.println("--- Pagos registrados ---");
        manager.showPayments();

    // Mostrar total de pagos procesados
        System.out.println("\nTotal de pagos: " + manager.totalPayments());
    // Buscar un pago por ID
    Payment buscado = manager.searchPaymentById(2);
        if (buscado != null) {
        System.out.println("Pago encontrado: ID " + buscado.getId() + " | Monto $" + buscado.getAmount());
    }
}// class PaymentsApp

