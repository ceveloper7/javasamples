package com.ceva.ch08.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test-case to test the AccountService class.
 * We use the custom mock AccountManager that we
 * implemented.
 */
public class TestAccountService {
    @Test
    public void testTransferOk() {
        // 1. Setup
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);

        // 2. Ejecucion
        accountService.transfer("1", "2", 50);

        // 3. Verificacion
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }
}
