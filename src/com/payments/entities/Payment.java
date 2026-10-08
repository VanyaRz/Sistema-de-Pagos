package com.payments.entities;
//clase abstracta que define la estructura de cualquier pago
public class Payment {
    // Atributos  (privados-encapsulados)
    private int id;              // Identificador único del pago
    private double amount;       // Monto del pago
    private boolean successful;  // Estado del pago (aprobado o rechazado)

    //constructor
    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
        this.successful = false; // Por defecto, el pago no está aprobado
    }

    // Getters y setters (encapsulación)
    public int getId() {
        return id;
    }//get Id
    public double getAmount() {
        return amount;
    }//get Amount

    public boolean isSuccessful() {
        return successful;
    }
    protected void setSuccessful(boolean successful) { this.successful = successful; }

    // Método abstracto: cada tipo de pago implementará su propia lógica
    //public abstract void processPayment();

}//class Payment
