package UnitTesting.Mocking;

/**
 * Created by Michael.Shreiber on 3/23/14.
 */


public interface AccountManager {
    Account findAccountForUser(String userId);

    void updateAccount(Account account);
}