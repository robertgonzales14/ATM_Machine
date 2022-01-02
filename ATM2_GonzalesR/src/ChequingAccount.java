/**
 *Date: Feb 18, 2021
 *Title: ASS2
 *@author Robert Gonzales
 *@version
 *
 *
 */
public class ChequingAccount extends Account{

	private double overdraftlimit =500;
	
	public ChequingAccount(int customerId, String name) {
		super(customerId, name);

		if(getAnnualIR() <= 1) {
			setAnnualIR(getAnnualIR());
		}
	}

	   public void withdraw(double withdraw) {
		 
	      if(withdraw <= getBalance()+ overdraftlimit)
	      {
	    	  super.withdraw(withdraw);
	      }
	      else
	      {
	    	  System.out.println("Overdraft Limit exceeded");//If user over goes overdraftlimit
	      }
	   }

	public void deposit(double deposit) {
		super.deposit(deposit + (deposit * 0.5)); //Adds a dollar for each dollar deposited
	}
}