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

    BankAccount(String numberAcc){
        this.numberAcc = numberAcc;
        this.balance = 0;
    }
    public double getBalance()
    {
        return 0;  //To change body of created methods use File | Settings | File Templates.
    }

    public String getNumAcc()
    {
        return this.numberAcc;  //To change body of created methods use File | Settings | File Templates.
    }
}
