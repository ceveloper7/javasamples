package com.ceva.two.objects.factorymethods.ventaja5;

/**
 * Fabrica de Procesadores de pago.
 * No crea el servicio directamente el framework, lo crea el proveedor.
 */
public interface PaymentProcessorProvider {
    PaymentProcessor create();
}
