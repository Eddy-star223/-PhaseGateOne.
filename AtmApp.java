public class AtmApp {

String firstName;
String lastName;
int pin;
double balance;

public AtmApp(String firstName, String lastName, int pin) {

this.firstName = firstName;
this.lastName = lastName;
this.pin = pin;
this.balance = 0.0;
   
 }

public void deposit(double amount) {
balance += amount;
System.out.println("Deposit successful! Your new balance is: " + balance);
    
}

public void withdraw(double amount, int accountPin) {

  do {
        if (accountPin != pin) {
            System.out.println("Incorrect PIN. Please try again.");
        }
    } while (accountPin != pin);

    if (amount <= balance) {
        balance -= amount;
        System.out.println("Withdrawal successful! Your new balance is: " + balance);
    } else {
        System.out.println("Insufficient balance.");
    }
}


    
    public void checkBalance(int accountPin) {
        if (accountPin == pin) {
            System.out.println("Your balance: " + balance);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }
    }

    
    public void changePin(int oldPin, int newPin) {
        if (oldPin == pin) {  
            if (newPin >= 1000 && newPin <= 9999) {
                pin = newPin;
                System.out.println("PIN changed successfully!");
            } else { 
                System.out.println("Invalid PIN! PIN must be a 4-digit number.");
            }
        } else {  
            System.out.println("Incorrect old PIN. PIN change failed.");
        }
    }
}

 




