/**
 *Date: Feb 18, 2021
 *Title: ASS2
 *@author Robert Gonzales
 *@version
 *
 *
 */
public class SavingsAccount extends Account{

	public SavingsAccount(int customerId, String name) {
		super(customerId, name);

		if(getAnnualIR() >= 3)
		{
			setAnnualIR(getAnnualIR());
		}
	}
	public void deposit(double deposit) {
		super.deposit(deposit + (deposit * 0.5)); //Adds half a dollar for each dollar deposited
	}
	
}