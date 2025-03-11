package com.ceva.helpers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * keyHelper es un no singleton bean
 * Clase que sabe como abrir un casillero
 */
@Component("keyHelper")
@Scope("prototype")
public class KeyHelper {
    public void open(){}
}
