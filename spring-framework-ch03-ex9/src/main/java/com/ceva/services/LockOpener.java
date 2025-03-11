package com.ceva.services;

import com.ceva.helpers.KeyHelper;

/*
 * Interface que expone el servicio para abrir un casillero
 */
public interface LockOpener {
    // clase helper que sabe como abrir un casillero
    KeyHelper getMyKeyOpener();
    void openLock();
}
