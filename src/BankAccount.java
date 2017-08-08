
public class BankAccount {

	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	private static int numberOfAccounts = 0;
	private static double moneyStored = 0;
	
	public void BankAccount() {
		this.accountNumber = generateAccount();
		numberOfAccounts++;
	}
	
	public String generateAccount() {
		String acc = "";
		int max = 10;
		int min = 0;
		
		for (int i = 0; i < 10; i++) {
			int random = (int)(Math.random()* max+min);
			acc = acc.concat(String.valueOf(random));
		}
		
		return acc;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public void deposit(String accountType, double amount) {
		String acc = accountType;
		if (acc.equals ("checking")) {
			this.checkingBalance += amount;
			moneyStored += amount;
		}
		else if(acc.equals("savings")) {
			this.savingsBalance += amount;
			moneyStored += amount;
		}
		else {
			System.out.println("Account not found");
		}
	}
	
	public void withdraw(String accountType, double amount) {
		String acc = accountType;

		if(acc.equals("checking")) {
			if(this.checkingBalance - amount < 0) {
				System.out.println("Insufficient funds");
			} else {
				this.checkingBalance -= amount;
				moneyStored -= amount;
			}
		} else if(acc.equals("saving")) {
			if(this.savingsBalance - amount < 0) {
				System.out.println("Insufficient funds");
			} else {
				this.savingsBalance -= amount;
				moneyStored -= amount;
			}
		} else {
			System.out.println("Could not find account with the name");
		}
	}
	
	public double accountBalance() {
		double total = this.checkingBalance + this.savingsBalance;
		return total;
	}
	
	public static double getTotalMoney() {
		return moneyStored;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	
	
	
}
