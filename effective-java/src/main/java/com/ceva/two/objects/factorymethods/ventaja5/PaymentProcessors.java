package com.ceva.two.objects.factorymethods.ventaja5;

import java.util.HashMap;
import java.util.Map;


/**
 * Corazon del sistema
 */
public class PaymentProcessors {
    private static final Map<String, PaymentProcessorProvider> providers = new HashMap<>();

    public static void registerProvider(String name, PaymentProcessorProvider provider){
        providers.put(name, provider);
    }

    // la fabrica busca el proveedor
    public static PaymentProcessor getProcessor(String name){
        PaymentProcessorProvider provider = providers.get(name);
        if(provider == null)
            throw new IllegalArgumentException("No provider found");

        // el provider crea el servicio
        return provider.create();
    }
}
