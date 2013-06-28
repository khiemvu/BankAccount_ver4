package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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
    @Test
    public void testGetInfoAboutBankAccount(){
        BankAccount bankAccount = BankAccountService.opentBankAccount("0123456789");
        BankAccountService.getBankAccInfo("0123456789");

        when(bankAccountDao.getInfoAboutAccount("0123456789")).thenReturn(bankAccount);

        ArgumentCaptor< BankAccount > bankAccountArgument = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDao).getInfoAboutAccount("0123456789");

        assertEquals(0, bankAccountArgument.getValue().getBalance(), 0.01);
        assertEquals("0123456789", bankAccountArgument.getValue().getNumAcc());
    }

}
