package BankAccountTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;
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

        verify(bankAccountDao).getInfoAboutAccount("0123456789");

        assertEquals(0, bankAccount.getBalance(), 0.01);
        assertEquals("0123456789", bankAccount.getNumAcc());
    }
    @Test
    public void testDoTransactionDeposit(){
        BankAccount bankAccount = BankAccountService.opentBankAccount("0123456789");
        when(bankAccountDao.getInfoAboutAccount("0123456789")).thenReturn(bankAccount);
        BankAccountService.doTransactionDeposit("0123456789", 100, "deposit");


        ArgumentCaptor< BankAccount > bankAccountArgument = ArgumentCaptor.forClass(BankAccount.class);
        verify(bankAccountDao, times(2)).saveAccount(bankAccountArgument.capture());
        verify(bankAccountDao).getInfoAboutAccount("0123456789");

        assertEquals(100, bankAccountArgument.getValue().getBalance(), 0.01);
        assertEquals("0123456789", bankAccountArgument.getValue().getNumAcc());
        assertEquals("deposit", bankAccountArgument.getValue().getDes());
    }

}
