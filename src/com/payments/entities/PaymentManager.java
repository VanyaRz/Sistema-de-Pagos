package com.payments.entities;

import java.util.ArrayList;
// Clase que administra todos los pagos realizados
public class PaymentManager {
    private ArrayList<Payment> payments; //Coleccion de pagos
    public PaymentManager() {
        payments =new ArrayList<>();
    }

    //REgistrar un pago (se procesa y se guarda en la lista)
    public void registerPayment(Payment payment) {
        payment.processPayment();
        payments.add(payment);
    }

    // Buscar un pago por su ID
    public Payment searchPaymentById(int id) {
        for (Payment p : payments) {
            if (p.getId() == id) return p;
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Mostrar el total de pagos procesados
    public int totalPayments() {
        return payments.size();
    }
}//class PaymentManager
