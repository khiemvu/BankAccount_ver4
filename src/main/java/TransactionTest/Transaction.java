package TransactionTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/29/13
 * Time: 6:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction
{
    private long time_stamp;
    private String accNum;
    private double amount;
    private String des;

    public Transaction(String accNum, long time_stamp, double amount, String des)
    {
        this.accNum = accNum;
        this.time_stamp = time_stamp;
        this.amount = amount;
        this.des = des;
        //To change body of created methods use File | Settings | File Templates.
    }

    public long getTime()
    {
        return this.time_stamp;  //To change body of created methods use File | Settings | File Templates.
    }
}
