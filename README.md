# Sistema de Pagos

Simulador de procesamiento de transacciones en Java que modela diferentes métodos de pago aplicando principios de Programación Orientada a Objetos (POO), colecciones y manejo de excepciones.

---

## Conceptos de POO Aplicados

- **Abstracción:** Definición del modelo genérico en la clase abstracta `Payment`, delegando la lógica específica a cada método de pago con `processPayment()`.
- **Encapsulamiento:** Protección de datos mediante modificadores de acceso (`private`, `protected`), getters y validaciones internas.
- **Herencia:** Especialización de `Payment` en clases hijas (`CreditCardPayment`, `PayPalPayment`, `BankTransferPayment`) para reutilizar atributos y comportamiento base.
- **Polimorfismo:** Sobrescritura (`@Override`) de `processPayment()` y `toString()`, permitiendo procesar y consultar cobros de forma homogénea.
- **Interfaces:** Contrato `Refundable` implementado únicamente por los métodos que admiten devoluciones de dinero.

---

## Estructura del Proyecto

```text
src/
└── com/
    └── payments/
        ├── PaymentsApp.java
        ├── entities/
        │   ├── BankTransferPayment.java
        │   ├── CreditCardPayment.java
        │   ├── Payment.java
        │   ├── PaymentManager.java
        │   └── PayPalPayment.java
        ├── enums/
        │   └── PaymentStatus.java
        ├── exceptions/
        │   ├── InsufficientFundsException.java
        │   └── InvalidPaymentException.java
        └── interfaces/
            └── Refundable.java
```

---

## Propósito de los Componentes

### Clases
- **`Payment`:** Clase abstracta base con datos comunes (`id`, `amount`, `status`) y la firma abstracta `processPayment()`.
- **`CreditCardPayment`:** Gestiona pagos con tarjeta de crédito, descuenta del límite disponible e implementa `Refundable`.
- **`PayPalPayment`:** Gestiona pagos asociados a un correo electrónico y saldo, e implementa `Refundable`.
- **`BankTransferPayment`:** Gestiona pagos por transferencia bancaria validando número de cuenta y saldo disponible.
- **`PaymentManager`:** Administra la lista de pagos en memoria (`ArrayList`), permitiendo registrar, listar y buscar transacciones por ID.
- **`PaymentsApp`:** Punto de entrada (`main`) que ejecuta pruebas de transacciones exitosas, fallidas y reembolsos.

### Interfaces
- **`Refundable`:** Define el contrato `refund()` para revertir transacciones en los métodos que lo admiten.

### Enumeraciones (Enum)
- **`PaymentStatus`:** Define los estados posibles de una transacción: `PENDING`, `APPROVED`, `REJECTED` y `REFUNDED`.

### Excepciones
- **`InsufficientFundsException`:** Se dispara cuando el saldo o límite disponible es menor al monto solicitado.
- **`InvalidPaymentException`:** Se dispara cuando los datos del pago son inválidos (formato de correo, cuenta bancaria incompleta, etc.).
