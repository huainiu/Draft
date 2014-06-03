package UnitTesting.Mocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

/**
 * Created by Michael.Shreiber on 3/24/14.
 */
public class TestAccountServiceEasyMock {
    //we declare the object that we would like to mock. Notice that our
    //AccountManager is an interface; the reason behind this is simple – the core EasyMock
    //framework can mock only interface objects.
    private AccountManager mockAccountManager;

    @Before
    @Ignore("experimantal project only for learning purposes.")
    public void setUp() {
        //we call the  createMock method to create a mock of the class that we want.
        mockAccountManager = createMock("mockAccountManager", AccountManager.class);
    }

    @Test
    @Ignore ("experimantal project only for learning purposes.")
    public void testTransferOk() {
        //we create two account objects that we are going to use in our tests.
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);

        //Start defining the expectations
        //When the method return type is void, you simply call it on the mock-object,
        //or when the method returns any kind of object, then you need to use the expect-andReturn methods from the EasyMock API.
        mockAccountManager.updateAccount(senderAccount);
        mockAccountManager.updateAccount(beneficiaryAccount);

        expect(mockAccountManager.findAccountForUser("1")).andReturn(senderAccount);
        expect(mockAccountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);

        //we’re done defining the expectations
        //you need to call the  replay method to announce it
        replay(mockAccountManager);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

    @After
    @Ignore ("experimantal project only for learning purposes.")
    public void tearDown()

    {
        verify(mockAccountManager);
    }
}

