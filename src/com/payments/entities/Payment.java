package com.payments.entities;
//clase abstracta que define la estructura de cualquier pago
public class Payment {
    // Atributos  (privados-encapsulados)
    private int id;              // Identificador único del pago
    private double amount;       // Monto del pago
    private boolean successful;  // Estado del pago (aprobado o rechazado)

}//class Payment
