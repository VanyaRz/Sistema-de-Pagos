package com.payments.entities;

public abstract class Payment {// abstract la clase no se puede usar directamente
    protected int id;
    protected double monto;
    protected Estado estado;

    // ============ CONSTRUCTOR ============
    public Payment(int id, double monto) {
        this.id = id;
        this.monto = monto;
        this.estado = Estado.PENDING;
    }

    public abstract void processPayment() throws Exception;
// Método abstracto: cada clase hija debe implementar su versión

    public Estado getEstado() {
        return estado;
    } // Método para consultar el estado actual del pago
}
enum Estado { PENDING, APPROVED, REJECTED } // enum lista de valores constantes
// Definir los estados de un pago

