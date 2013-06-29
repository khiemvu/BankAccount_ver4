package TransactionTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/29/13
 * Time: 6:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction
{
    @Mock
    private Date timestamp;
    @Mock
    private TransactionDAO transactionDAO;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        TransactionService.setUpData(transactionDAO);
    }

    @Test
    public void testGetTimestampWhenDepositAndWithdraw()
    {
        TransactionService.doTransaction("0123456789", 100L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 1000L, -50, "withdraw");

        ArgumentCaptor<Transaction> transactionArgument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO, times(2)).saveTransaction(transactionArgument.capture());

        List<Transaction> transactionList = transactionArgument.getAllValues();
        when(timestamp.getTime()).thenReturn(100L);
        assertEquals(timestamp.getTime(), transactionList.get(0).getTime());

        when(timestamp.getTime()).thenReturn(1000L);
        assertEquals(timestamp.getTime(), transactionList.get(1).getTime());

    }
    @Test
    public void testGetAllTransaction()
    {
        TransactionService.doTransaction("0123456789", 100L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 1000L, 50, "deposit");

        ArgumentCaptor<Transaction> transactionArgument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO, times(2)).saveTransaction(transactionArgument.capture());
        List<Transaction> transactionList = transactionArgument.getAllValues();

        when(transactionDAO.getAllTransaction("0123456789")).thenReturn(transactionList);
        assertEquals(2, transactionList.size());
        assertEquals(100, transactionList.get(0).getBalance(), 0.01);

    }

    @Test
    public void testGetAllTransactionInAboutTime()
    {
        TransactionService.doTransaction("0123456789", 100L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 1000L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 2000L, 100, "withdraw");

        ArgumentCaptor<Transaction> transactionArgument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO, times(3)).saveTransaction(transactionArgument.capture());
        List<Transaction> transactionList = transactionArgument.getAllValues();

        when(transactionDAO.getAllTransaction("0123456789", 10L, 10000L)).thenReturn(transactionList);
        assertEquals(3, transactionList.size());
        assertEquals(100, transactionList.get(2).getBalance(), 0.01);

    }
    @Test
    public void testGetNewTransaction()
    {
        TransactionService.doTransaction("0123456789", 100L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 1000L, 100, "deposit");
        TransactionService.doTransaction("0123456789", 2000L, 100, "withdraw");

        ArgumentCaptor<Transaction> transactionArgument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO, times(3)).saveTransaction(transactionArgument.capture());
        List<Transaction> transactionList = transactionArgument.getAllValues();

        when(transactionDAO.getAllTransaction("0123456789", 3)).thenReturn(transactionList);
        assertEquals(3, transactionList.size());
        assertEquals(100, transactionList.get(2).getBalance(), 0.01);

    }
    }
