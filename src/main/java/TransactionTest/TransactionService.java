package TransactionTest;

import java.util.List;

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

    public static Transaction doTransaction(String accNum, long time, double amount, String des)
    {
        Transaction transaction = new Transaction(accNum, time, amount, des);
        transactionDAO.saveTransaction(transaction);
        return transaction;  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<Transaction> getAllTransaction(String accNumber)
    {
        return transactionDAO.getAllTransaction(accNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public List<Transaction> getAllTransaction(String accNumber, long time_start, long time_stop)
    {
        return transactionDAO.getAllTransaction(accNumber,time_start, time_stop);  //To change body of created methods use File | Settings | File Templates.
    }
    public List<Transaction> getAllTransaction(String accNumber, int number)
    {
        return transactionDAO.getAllTransaction(accNumber,number);  //To change body of created methods use File | Settings | File Templates.
    }
}
