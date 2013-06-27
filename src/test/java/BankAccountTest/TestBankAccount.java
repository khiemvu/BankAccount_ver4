package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;


/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/27/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount
{
    @Mock
    private BankAccountDao bankAccountDao;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        BankAccountService.setupData(bankAccountDao);
    }
    @Test
    public void testOpentBankAccount(){
        BankAccountService.opentBankAccount("0123456789");

        ArgumentCaptor<BankAccount> bankAccountArgument = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDao).saveAccount(bankAccountArgument.capture());

        assertEquals(0, bankAccountArgument.getValue().getBalance(), 0.01);
    }

}
