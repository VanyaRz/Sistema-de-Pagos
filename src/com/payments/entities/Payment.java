package com.payments.entities;

public abstract class Payment {
    protected int id;
    protected double amount;
    protected Estado estado;

    public Payment(int id, double amount) {
        this.id = id;
        this.amount = amount;
        this.estado = Estado.PENDING;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Estado getEstado() {
        return estado;
    }

    protected void setEstado(Estado estado) {
        this.estado = estado;
    }

    public abstract void processPayment() throws Exception;

    @Override
    public String toString() {
        return "ID: " + id + " | Monto: $" + amount + " | Estado: " + estado;
    }
}

enum Estado { PENDING, APPROVED, REJECTED, REFUNDED }
