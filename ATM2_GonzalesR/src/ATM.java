/**
 *Date: Feb 18, 2021
 *Title: ASS2
 *@author Robert Gonzales
 *@version
 *
 *
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ATM {

	 boolean exit;
	 private static DecimalFormat round = new DecimalFormat("0.00");//Used for formatting the numbers to 2 decimal places

	public static void main(String args[]) 
	{
		Scanner input = new Scanner(System.in);
		//Calls getID method
		ATM menu = new ATM ();//Initializes menu
		Account one = new Account(101, "Robert Gonzales"); //First account already in the array
		Account two = new Account(102, "Emma Watson"); // Second account already in the array
		
		ArrayList<Account> accounts = new ArrayList<Account>(); //Creates an array for the accounts

		one.setBalance(50); //Sets balance to first array
		one.setAnnualIR(5); //Sets annualIR to first array
		
		two.setBalance(1000); 
		two.setAnnualIR(5);
		
		
		accounts.add(one); //adds objects one to array
		accounts.add(two); //adds objects two to array

		int id; //declares id
		boolean validation = true;
		while(validation)
		{
			System.out.println("Enter a valid account ID");
			id = input.nextInt();
			for (Account a: accounts){ //iterator and scans if the id is in the variable
				 if(a.getcustomerId() == id) {
				
					accounts = menu.runmenu(a,accounts); //runs the method with the object inputed
					break;
				 }
				
			}

	}
		
}
	
	//This class allows for the usage of the ATM
	public ArrayList<Account> runmenu(Account acc, ArrayList<Account> accounts) {
		
		Scanner input = new Scanner(System.in);
		while(!exit) 
		{
			
			System.out.println("\nMain Menu\n1: Create Account\n2: Account info\n3: Withdraw\n4: Deposit\n5: Exit\n");
			int choice = getInput();
			switch(choice) {
			case 1: //If users types 1 on input, call case 1
				String name;
				int newid; //intializes newid
				int status; //intializes status
				double newBalance; //intializes new balance
				double newannualIR; //intializes new annualIR
				
				boolean uniqueID = false;
				
				if(accounts.size() < 10) //Sets a limit of 10 in the array
				{
				System.out.println("Enter new account ID"); //Asks user to create a new account ID
				newid = input.nextInt();
				while(true) {
					for(Account a: accounts) { //iterator to scan if the ID is already taken
						if(a.getcustomerId() == newid) {
							uniqueID = false;
							break;
						}
						uniqueID = true;
					}
					if (uniqueID) {
						break;
					}
					else {
						System.out.println("ID already register, please enter a new account ID"); //If ID is already registered, asks user to input new ID
						newid = input.nextInt();
					}
				}	
				System.out.println("Account Name:"); //asks the user for account name
				input.nextLine();
				name = input.nextLine();
				
				System.out.println("New Balance:"); //asks the user for the new balance
				newBalance = input.nextDouble();
				
				System.out.println("New Annual IR: Chequing Max 1% || Savings Min 3%"); //asks the user for the annual IR
				newannualIR = input.nextDouble();
				
				
				System.out.println("Checkings or Savings account?(1 for chequing, 2 for savings)");//asks the user to input for checkings or savings
				status = input.nextInt();
				
				
				if (status == 1){ // if user chooses checking
					ChequingAccount chequing = new ChequingAccount(newid, name);
					chequing.setBalance(newBalance);
					chequing.setAnnualIR(newannualIR);
					accounts.add(chequing);
				}
				else if (status == 2) // if user chooses savings
				{
					SavingsAccount savings = new SavingsAccount(newid, name);
					savings.setBalance(newBalance);
					savings.setAnnualIR(newannualIR);
					accounts.add(savings);
				}
				
			}
				else
				{
					System.out.println("Accounts maxed out"); //If user tries to input another account, tells the user accounts maxed
				}
				
			case 2: //If user types 2 in input call case 2
				
				Date date = new Date();//Needed to display date
				System.out.println("Customer: " + acc.getCustomerName());//Displays customer name
				System.out.println("Account Balance: $" + round.format(acc.getBalance()));//Displays current balance
				System.out.println("Monthly Interest: " + round.format(acc.getBalance() * acc.getAnnualIR() / 12 / 100));//Displays interest rate depending on the balance
				System.out.println("Date: " + date + "\n");//Display date
				break;
				
			case 3: //If user types 3	
				double withdraw = 0; //Initializes withdraw variable
				
				System.out.println("How much do you want to withdraw?"); //Asks the user how much they want to withdraw
				withdraw = input.nextDouble();//Takes the inputed value and stores it in the withdraw variable
				acc.withdraw(withdraw);
				if(withdraw > acc.getBalance()) {// if users withdraw is greater than the balance
					System.out.println("Insufficient funds"); 
				}
				System.out.println("New Balance: " + round.format(acc.getBalance())); //outputs current balance
				
				break;
				
			case 4://If user types 4 calls case 4
				
				double deposit;
				System.out.println("How much do you want to deposit?");//Asks the user how much he wants to deposit
				deposit = input.nextDouble();//Stores inputed value in deposit
				
				acc.deposit(deposit); //calls deposit in account
				System.out.println("New Balance: " + round.format(acc.getBalance())); //outputs current balance
				
				break;
				
			case 5: //If user inputs 5 call case 5 and return to main method
				
				return accounts; //returns to main method with the newly inputed objects
				
			}

		}
		return accounts; //returns to main method with the newly inputed objects
	}
	
	
	private int getInput()
	{
		
		Scanner input = new Scanner(System.in);
		
		int choice = -1;
		
		//Try Catch, will only allow values from 1-4
		while(choice < 1 || choice > 5) 
		{
			
			try 
			{
				//Asks user to input a category
				System.out.print("Please choose what you'd like to do: \n");
				choice = Integer.parseInt(input.nextLine());
			}
			//If user inputs a wrong variable
			catch(NumberFormatException e) {
				System.out.println("Invalid selection. Try again");
				
			}
		}
		//returns choice
	return choice;
	
	}

}
		

