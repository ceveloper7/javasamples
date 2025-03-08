package org.ceva.ch08.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test-case to test the AccountService class by means of the Mockito framework.
 * @ExtendWith permite registrar extensiones para una clase de prueba que usa anotaciones
 * Para nuestro ejemplo, necesitamos esta extension para poder crear mock objects
 */
@ExtendWith(MockitoExtension.class)
public class TestAccountServiceMockito {
    /**
     * Create The mock instance of the AccountManager to use.
     */
    @Mock
    private AccountManager mockAccountManager;

    @Test
    public void testTransferOk() {
        // creacion de objeto Account para realizar la operacion
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        /**
         * empezamos declarando las expectativas usando el metodo when
         * el metodo lenient() modifica la exactitud del mock object, si este metodo
         * solo una declaracion de espectativa se permite para el metodo findAccountForUser()
         * cuando se necesitan dos
         */
        Mockito.lenient().when(mockAccountManager.findAccountForUser("1")).thenReturn(senderAccount);
        Mockito.lenient().when(mockAccountManager.findAccountForUser("2")).thenReturn(beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        // transferimos el dinero
        accountService.transfer("1", "2", 50);

        // realizamos las afirmaciones
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }
}
