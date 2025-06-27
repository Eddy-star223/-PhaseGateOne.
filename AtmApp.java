import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAtm {

private String firstName;
private String lastName;
private int pin;
private double balance;
private boolean accountCreated = false; 

Scanner input = new Scanner(System.in);
static List<BankAtm> accounts = new ArrayList<>();

public void getFullName() {
System.out.println(firstName + " " + lastName);
}
    
public void createAccount() {
        
System.out.print("Enter First Name: ");
firstName = input.nextLine();
System.out.print("Enter Last Name: ");
lastName = input.nextLine();
System.out.print("Set a 4-digit PIN: ");
pin = input.nextInt();
        
if (String.valueOf(pin).length() == 4) {
	balance = 0.0; 
	accountCreated = true;
	accounts.add(this);
System.out.println("Account Created Successfully! Welcome, " + firstName + " " + lastName);
} else {
	System.out.println("Invalid PIN! Must be exactly 4 digits.");
}
input.nextLine();
}

public static BankAtm accountByName(String accountName) {
String[] storeName = accountName.trim().split(" ");
	
	if (storeName.length < 2) {
System.out.println("Full name must include first and last name.");

	return null;
}

String firstName = storeName[0];
String lastName = storeName[1];

for (BankAtm account : accounts)
if (account.firstName.equalsIgnoreCase(firstName) && account.lastName.equalsIgnoreCase(lastName)) {
	return account;
}

return null;
} 
      
public void deposit() {
        
if (!accountCreated) {
	System.out.println("No account found! Please create an account first.");
	return;
 }
System.out.print("Enter deposit amount: ");
double amount = input.nextDouble();
balance += amount;
System.out.println("Deposit successful! New balance: " + balance);
}

public void withdraw() {
	if (!accountCreated) {
System.out.println("No account found! Please create an account first.");
	return;
}
System.out.print("Enter PIN: ");
int accountPin = input.nextInt();

if (accountPin != pin) {
System.out.println("Incorrect PIN. Withdrawal canceled.");
	return;
}

System.out.print("Enter withdrawal amount: ");
double amount = input.nextDouble();

if (amount <= balance) {
	balance -= amount;
System.out.println("Withdrawal successful! New balance: " + balance);
} else {
System.out.println("Insufficient balance.");
}
    }

public void checkBalance() {
	if (!accountCreated) {
System.out.println("No account found! Please create an account first.");
	return;
}
System.out.print("Enter PIN: ");
int accountPin = input.nextInt();

if (accountPin == pin) {
System.out.println("Your balance: " + balance);
} else {
	System.out.println("Incorrect PIN. Access denied.");
}
}

public void changePin() {
	if (!accountCreated) {
System.out.println("No account found! Please create an account first.");
	return;
}
System.out.print("Enter old PIN: ");
int oldPin = input.nextInt();

if (oldPin == pin) {
System.out.print("Enter new 4-digit PIN: ");
int newPin = input.nextInt();

if (String.valueOf(newPin).length() == 4) {
	pin = newPin;
System.out.println("PIN changed successfully!");
} else {
	System.out.println("Invalid PIN! PIN must be exactly 4 digits.");
}
} else {
	System.out.println("Incorrect old PIN. PIN change failed.");
}
}

public void transfer(BankAtm receiver) {
        if (!accountCreated) {
System.out.println("No account found! Please create an account first.");
            return;
        }

System.out.print("Enter your PIN: ");
int enteredPin = input.nextInt();

if (enteredPin != pin) {
System.out.println("Incorrect PIN.");
	return;
}

System.out.print("Enter transfer amount: ");
double amount = input.nextDouble();

if (amount <= balance) {
	balance -= amount;
	receiver.balance += amount;
System.out.println("Transfer successful! new balance is: " + balance);
   } else {
	  System.out.println("Insufficient balance.");
}
}
 
public void showMenu() {
int choice;
	do {
	    System.out.println();
	    System.out.println("==========================");
            System.out.println("\nATM MENU");
	    System.out.println("==========================");
	    System.out.println();
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Change PIN");
	    System.out.println("6. Transfer");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");
            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> changePin();
		case 6 -> {
    System.out.print("Enter receiver's full name: ");
    String receiverName = input.nextLine();
    BankAtm receiver = accountByName(receiverName);
    if (receiver != null && receiver != this) {
        transfer(receiver);
    } else if (receiver == this) {
        System.out.println("You can't transfer to yourself.");
    } else {
        System.out.println("Receiver not found.");
    }
}

                case 7 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option! Try again.");
            }
        } while (choice != 7);

      }



public static void main(String[] args) {
    BankAtm atm = new BankAtm();
    atm.showMenu();
}

}

