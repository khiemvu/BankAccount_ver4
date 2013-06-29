package BankAccountTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/27/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount
{
    String numberAcc;
    double balance;
    String desciption;
    private long time_stamp;

    BankAccount(String numberAcc, long time_stamp){
        this.numberAcc = numberAcc;
        this.balance = 0;
        this.time_stamp = time_stamp;
    }
    public double getBalance()
    {
        return this.balance;  //To change body of created methods use File | Settings | File Templates.
    }

    public String getNumAcc()
    {
        return this.numberAcc;  //To change body of created methods use File | Settings | File Templates.
    }

    public String getDes()
    {
        return this.desciption;  //To change body of created methods use File | Settings | File Templates.
    }

    public void setBalance(double balance)
    {
        this.balance = balance;//To change body of created methods use File | Settings | File Templates.
    }

    public void setDes(String desciption)
    {
        this.desciption = desciption;//To change body of created methods use File | Settings | File Templates.
    }

    public long getTime()
    {
        return this.time_stamp;  //To change body of created methods use File | Settings | File Templates.
    }
}
