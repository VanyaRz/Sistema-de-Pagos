package com.payments;

import com.payments.entities.*;
import com.payments.exceptions.InsufficientFundsException;

public class PaymentsApp {
    public static void main(String[] args) {
        // Crear administrador de pagos
        PaymentManager manager = new PaymentManager();

        try {
            // Crear diferentes tipos de pagos
            Payment p1 = new CreditCardPayment(1, 1000, "1234-5678-9012", "Juan Perez", 5000);
            manager.registerPayment(p1);
        } catch (Exception e) {
            System.out.println("Error procesando pago 1: " + e.getMessage());
        }

        try {
            Payment p2 = new PayPalPayment(2, 850, "cliente@email.com", 1000);
            manager.registerPayment(p2);
        } catch (Exception e) {
            System.out.println("Error procesando pago 2: " + e.getMessage());
        }

        try {
            Payment p3 = new BankTransferPayment(3, 2000, "987654321", "Banco XYZ", 1500);
            manager.registerPayment(p3);
        } catch (Exception e) {
            System.out.println("Error procesando pago 3: " + e.getMessage());
        }

        try {
            // Un pago fallido por fondos insuficientes
            PayPalPayment pagoFallido = new PayPalPayment(4, 300, "usuario@mail.com", 200);
            manager.registerPayment(pagoFallido);
        } catch (Exception e) {
            System.out.println("Error procesando pago 4: " + e.getMessage());
        }

        // Mostrar todos los pagos registrados
        System.out.println("\n--- Pagos registrados ---");
        manager.showPayments();

        // Mostrar total de pagos procesados
        System.out.println("\nTotal de pagos: " + manager.totalPayments());
        
        // Buscar un pago por ID
        Payment buscado = manager.searchPaymentById(2);
        if (buscado != null) {
            System.out.println("Pago encontrado: " + buscado.toString());
        }
    }
}
