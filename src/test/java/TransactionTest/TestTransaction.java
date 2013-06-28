package TransactionTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        TransactionService.setUpData(transactionDAO);
    }
    @Test
    public void testGetTimestampWhenDeposit(){
        TransactionService.transactionDeposit("0123456789", 1000L, 100, "deposit");
        when(timestamp.getTime()).thenReturn(1000L);
        ArgumentCaptor<Transaction> transactionArgument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO).saveTransaction(transactionArgument.capture());

        assertEquals(timestamp.getTime(), transactionArgument.getValue().getTime());
    }
    @Test
    public void testGetTimestampWhenWithdraw(){

        TransactionService.transactionWithdraw("0123456789", 1000L, 100, "withdraw");
        when(timestamp.getTime()).thenReturn(1000L);
        ArgumentCaptor<Transaction> transactionArgument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionDAO).saveTransaction(transactionArgument.capture());

        assertEquals(timestamp.getTime(), transactionArgument.getValue().getTime());
    }

}
