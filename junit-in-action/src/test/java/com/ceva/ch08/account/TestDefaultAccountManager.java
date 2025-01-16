package com.ceva.ch08.account;

import com.ceva.ch08.configurations.MockConfiguration;
import org.junit.jupiter.api.Test;

/**
 * A test-case for the DefaultAccountManager class.
 */
public class TestDefaultAccountManager {
    @Test
    public void testFindAccountByUser() {
        /**
         * Controlamos completamente el comportamiento Logging y Configuration
         * El codigo es mas flexible y permite cualquier implementacion de logging y configuration
         */
        MockLog logger = new MockLog();
        MockConfiguration configuration = new MockConfiguration();
        configuration.setSQL("SELECT * [...]");
        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);

        @SuppressWarnings("unused")
        Account account = am.findAccountForUser("1234");

        // Perform asserts here
    }
}
