package TransactionTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/29/13
 * Time: 6:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionService
{
    private static TransactionDAO transactionDAO;
    public static TransactionDAO setUpData(TransactionDAO transactionDAO)
    {
        return TransactionService.transactionDAO = transactionDAO;  //To change body of created methods use File | Settings | File Templates.
    }

    public static Transaction transactionDeposit(String accNum, long time, double amount, String des)
    {
        Transaction transaction = new Transaction(accNum, time, amount, des);
        transactionDAO.saveTransaction(transaction);
        return transaction;  //To change body of created methods use File | Settings | File Templates.
    }
}
