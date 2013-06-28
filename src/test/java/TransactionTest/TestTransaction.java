package TransactionTest;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

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
}
