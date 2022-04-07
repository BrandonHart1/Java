public class BankAccount // -------- bank account class --------
{
    // -------- attributes --------
    private Double checking; // if private isn't specified, default to protected/private
    private Double savings;
    private static Integer numberOfAccounts = 0;
    public static  int createdAccount = 0;


    // -------- constructor --------
    public BankAccount()
    {
        numberOfAccounts += 1;
        Double checking = 0.00;
        Double savings = 0.00;
        Double checkingBalance = 0.00;
        Double savingsBalance = 0.00;
    
    }


    // -------- checking getter --------
    public Double getCheckingBalance() 
    { 
        return checking;
        // System.out.println("Checking Account Balance: " + this.checking);
    }


    // -------- checking setter --------
    public Double setChecking() 
    { 
        return checking;
    }

    
    // -------- savings getter --------
    public Double getSavingBalance() 
    {
        return savings;
        // System.out.println("Savings Account Balance: " + this.savings);

    }

    public Double setSavings()
    {
        return savings;
    }

    // -------- deposit --------
    public void deposit(Double deposit, Boolean isChecking) 
    {
        if(isChecking){
            checking += deposit;
        } else {
            savings += deposit;
        }
    }


    // -------- withdrawel --------
    public Double withdrawel(Double deposit, Boolean isChecking)
    {
    if(isChecking)
    {
        if(checking < deposit) {
            return 0.00;
        }
        checking -= deposit;
    }
    else
    {
        if(savings < deposit) {
            return 0.00;
        }
        savings -= deposit;
    }
    return deposit;
    }


}
