package com.payments.entities;

import java.util.ArrayList;

// Clase que administra todos los pagos realizados
public class PaymentManager {
    private ArrayList<Payment> payments; // Coleccion de pagos
    
    public PaymentManager() {
        payments = new ArrayList<>();
    }

    // Registrar un pago (se procesa y se guarda en la lista)
    public void registerPayment(Payment payment) {
        payments.add(payment);
    }

    // Mostrar todos los pagos
    public void showPayments() {
        for (Payment p : payments) {
            System.out.println(p.toString());
        }
    }

    // Buscar un pago por su ID
    public Payment findPaymentById(String id) {
        for (Payment p : payments) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    // Mostrar el total de pagos procesados
    public int totalPayments() {
        return payments.size();
    }

}
