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
}
