package com.ceva.jpersis.ch03.validation;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class ModelValidation {

    @Test
    public void validateItem(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Item item = new Item();
        item.setName("Some Item");
        item.setAuctionEnd(new Date());

        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        // tomamos la primera violacion encontrada
        ConstraintViolation<Item> violation = violations.iterator().next();
        // obtenemos el nombre del atributo que fallo la violacion, en este caso auctionEnd
        String failedPropertyName = violation.getPropertyPath().iterator().next().getName();

        // Validation error, auction end date was not in the future!
        assertAll(
                // nro de validaciones
                () -> assertEquals(1, violations.size()),
                // nombre del atributo fallado (auctionEnd)
                () -> assertEquals("auctionEnd", failedPropertyName),
                () -> {
                    // mensaje asociado si el idioma del sistema es ingles
                    if(Locale.getDefault().getLanguage().equals("en"))
                        assertEquals(violation.getMessage(), "must be a future date");
                }
        );
    }
}
