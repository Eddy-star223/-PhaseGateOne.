import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MentralCalculator {
	public static void main(String[] args) {
        	Scanner input = new Scanner(System.in);
        	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

while (true) {
	System.out.print("Enter the first day of your menstrual cycle (dd/MM/yyyy): ");
	String firstDay = input.nextLine();
	LocalDate firstDayDate = LocalDate.parse(firstDay, dateFormat);

	System.out.print("Enter your average cycle length: ");
	int length = input.nextInt();
	input.nextLine(); 

	LocalDate ovulation = firstDayDate.plusDays(length - 14);
	LocalDate beginFertile = ovulation.minusDays(5);
	LocalDate endFertile = ovulation.plusDays(1);

            
System.out.println("\nYour next Ovulation Date is: " + ovulation.format(dateFormat));
System.out.println();
System.out.println("If there is no fertilization, your hormone level starts dropping from: "  + beginFertile.format(dateFormat) + " to " + endFertile.format(dateFormat));

String userChoice;
            
do {
	System.out.print("\nDo you want to continue? (yes or no): ");
	userChoice = input.nextLine().trim().toLowerCase();

	if (userChoice.equals("yes")) {
			break;
	}
                 
	else if (userChoice.equals("no")) {
		System.out.println();
		System.out.println("Thank you using my Menstrual App..");
			input.close();
			return;
	}
	
	else {
		System.out.println("Invalid input. Please enter (yes or no)");
	}

  } while (true);

}
}
}