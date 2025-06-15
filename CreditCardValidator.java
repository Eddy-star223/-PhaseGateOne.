import java.util.Scanner;

public class CreditCardValidator {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

System.out.print("Hello, kindly enter card detail to verify: ");
String cardNumber = scanner.nextLine().replaceAll("[^0-9]", "");
System.out.println();

while (true) {
if (cardNumber.length() < 13 || cardNumber.length() > 16) {
System.out.println("Invalid card length.");
	return;
}

String cardType = cardType(cardNumber);
if (cardType == null) {
    System.out.println("Invalid card number.");
            return;
        } }

if (validCardNumber(cardNumber)) {	
	System.out.println("Credit card type: " + cardType);
	System.out.println("Credit card number: " + cardNumber);
	System.out.println("Credit card digit length: " + cardNumber.length());
	System.out.println("Credit card validity status: Valid");
} else {
	System.out.println("Credit card type: " + cardType);
	System.out.println("Credit card number: " + cardNumber);
	System.out.println("Credit card digit length: " + cardNumber.length());
	System.out.println("Credit card validity status: Invalid");
 }
}


public static String cardType(String cardNumber) {

	if (cardNumber.startsWith("4")) {
		return "Visa";
	} else if (cardNumber.startsWith("5")) {
		return "MasterCard";
        } else if (cardNumber.startsWith("37")) {
		return "American Express";
	} else if (cardNumber.startsWith("6")) {
		return "Discover";
        }
	return null;
    }

public static boolean validCardNumber(String cardNumber) {
int sum = 0;
boolean doubleNumber = false;

for (int i = cardNumber.length() - 1; i >= 0; i--) {
int digit = Character.getNumericValue(cardNumber.charAt(i));
if (doubleNumber) {
digit *= 2;
if (digit > 9) {
digit -= 9;
  }
}
sum += digit;
doubleNumber = !doubleNumber;
 }

	return sum % 10 == 0;
 }
}




