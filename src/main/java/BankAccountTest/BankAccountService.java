package BankAccountTest;

/**
 * Created with IntelliJ IDEA.
 * User: All_in_one
 * Date: 6/27/13
 * Time: 1:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountService
{
    private static BankAccountDao bankAccountDao;
    public static void setupData(BankAccountDao bankAccountDao)
    {
        BankAccountService.bankAccountDao = bankAccountDao;
    }

    public static BankAccount opentBankAccount(String accNumber)
    {
        BankAccount bankAccount = new BankAccount(accNumber);
        bankAccountDao.saveAccount(bankAccount);
        return bankAccount;  //To change body of created methods use File | Settings | File Templates.
    }

    public static BankAccount getBankAccInfo(String accNumber)
    {
        BankAccount bankAccount = bankAccountDao.getInfoAboutAccount(accNumber);
        return bankAccount;  //To change body of created methods use File | Settings | File Templates.
    }

    public static BankAccount doTransactionDeposit(String accNumber, double amount, String des)
    {
        BankAccount bankAccount = bankAccountDao.getInfoAboutAccount(accNumber);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        bankAccount.setDes(des);
        bankAccountDao.saveAccount(bankAccount);
        return bankAccount;  //To change body of created methods use File | Settings | File Templates.
    }
}
