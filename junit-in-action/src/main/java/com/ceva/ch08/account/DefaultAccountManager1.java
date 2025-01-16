package com.ceva.ch08.account;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Default account manager implementation before refactoring has two problems:
 * 1. No es posible usar un objeto Log distinto del que se define en la clase (una clase deberia usar un Log que se le proporcione)
 * 2. El PropertyResourceBundle quita flexibilidad por ejemplo no podemos usar XML
 */
public class DefaultAccountManager1 implements AccountManager{
    /**
     * Logger instance.
     */
    private static final Log logger = LogFactory.getLog(DefaultAccountManager1.class);

    /**
     * Finds an account for user with the given userID.
     *
     * @param
     */
    public Account findAccountForUser(String userId) {
        logger.debug("Getting account for user [" + userId + "]");
        ResourceBundle bundle = PropertyResourceBundle.getBundle("technical");
        String sql = bundle.getString("FIND_ACCOUNT_FOR_USER");

        // Some code logic to load a user account using JDBC
        return null;
    }

    /**
     * Updates the given account.
     *
     * @param
     */
    public void updateAccount(Account account) {
        // Perform database access here
    }
}
