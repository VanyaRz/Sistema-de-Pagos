package com.payments.entities;

import com.payments.enums.PaymentStatus;
import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;
import com.payments.interfaces.Refundable;


public class CreditCardPayment extends Payment implements Refundable {

    // Número de tarjeta del cliente (16 dígitos, datos ficticios)
    private final String cardNumber;

    // Nombre del titular de la tarjeta
    private final String holderName;

    // Límite de crédito disponible. Disminuye al aprobar un pago,
    // aumenta al reembolsarlo.
    private double availableLimit;
    
    public CreditCardPayment(String id, double amount,
                             String cardNumber, String holderName,
                             double availableLimit) {
        // Llamada al constructor de la clase padre (Payment).
        // Obligatoria porque Payment no tiene constructor sin argumentos.
        super(id, amount);

        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.availableLimit = availableLimit;
    }

    @Override
    public void processPayment() throws InsufficientFundsException {

        // Validación: el monto no puede superar el límite disponible.
        if (getAmount() > availableLimit) {
            // Marcamos el pago como rechazado ANTES de lanzar la excepción,
            // para que quede registro del intento fallido.
            setStatus(PaymentStatus.REJECTED);

            // Lanzamos la excepción con un mensaje claro que incluye los montos.
            throw new InsufficientFundsException(
                    "Límite insuficiente. Disponible: " + availableLimit
                            + ", requerido: " + getAmount());
        }

        // Hay límite suficiente: descontamos el monto del límite disponible.
        availableLimit -= getAmount();

        // Marcamos el pago como aprobado.
        setStatus(PaymentStatus.APPROVED);
    }

    @Override
    public void refund() throws InvalidPaymentException {

        // Validación: solo se reembolsan pagos que fueron aprobados.
        if (getStatus() != PaymentStatus.APPROVED) {
            throw new InvalidPaymentException(
                    "Solo se reembolsan pagos aprobados. Estado actual: "
                            + getStatus());
        }

        // Restauramos el monto al límite disponible.
        availableLimit += getAmount();

        // Marcamos el pago como reembolsado.
        setStatus(PaymentStatus.REFUNDED);
    }

    public double getAvailableLimit() {
        return availableLimit;
    }

    public String getHolderName() {
        return holderName;
    }


    @Override
    public String toString() {
        return super.toString()
                + " | tarjeta: " + cardNumber
                + " | titular: " + holderName;
    }
}



