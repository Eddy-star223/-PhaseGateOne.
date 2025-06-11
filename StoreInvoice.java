import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class StoreInvoice {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Date now = new Date();
	SimpleDateFormat formatTime = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");

String date = formatTime.format(now); 

System.out.println();
System.out.println("Welcome to Semicolon Store!");
System.out.println();

System.out.print("What is the customer's Name: ");
String name = input.nextLine();

double total = 0;

while (true) {
	System.out.print("What did the user buy? ");
	String itemName = input.nextLine();

	System.out.print("How many pieces? ");
	int pieces = input.nextInt();

	System.out.print("How much per unit? ");
	double unit = input.nextDouble();
        input.nextLine(); 

            
	double itemTotal = pieces * unit;
	//Items.add(new Item(itemName, pieces, unit, itemTotal));
	total += itemTotal;

            
	System.out.print("Add more Items? (yes or no): ");
	String moreItems = input.nextLine().trim().toLowerCase();

            if (moreItems.equals("no")) {
                break;
            } else if (!moreItems.equals("yes")) {
                System.out.println("Invalid input. Please enter (yes or no)");
                break;
            }
        }

        
        System.out.print("What is your name? ");
        String cashierName = input.nextLine();

      
        System.out.print("How much discount will the customer get? ");
        double discount = input.nextDouble();

        double vatRate = 17.50;
        double discountAmount = (discount / 100) * total;
        double vat = (total - discount) * vatRate / 100;
        double totalBill = total - discount + vat;

System.out.println();        
System.out.println("SEMICOLON STORES");
System.out.println("MAIN BRANCH");
System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
System.out.println("Date: " + date );
System.out.println("Cashier's Name: " + cashierName);
System.out.println("Customer Name: " + name);
System.out.println();
System.out.println("""
================================================
ITEM	QTY	PRICE	TOTAL(NGN)
------------------------------------------------
""");

//System.out.println(itemName + pieces + unit + total);



System.out.println("Sub Total: " +	total);
System.out.println("Discount: " +	discountAmount);
System.out.printf("VAT: " +	vat);
System.out.println();
System.out.println();
System.out.println("===============================================");
System.out.println("Total Bill: " +	totalBill);
System.out.println("===============================================");
System.out.println();
System.out.println("How much did the customer give to you?");

}

}



















