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


}//class PaymentManager
