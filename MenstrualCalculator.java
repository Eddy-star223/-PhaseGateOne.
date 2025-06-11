import java.time.LocalDate;
import java.time.format.dateTimeFormatter;
import java.util.Scanner;

public class MenstrualCalculator {

public static LocalDate firstDateCycle(Scanner input, dateTimeFormatter, dateFormat) {
System.out.print("Enter the first day of your menstrual cycle (dd/MM/yyyy): ");
String firstDay = input.nextLine();
return LocalDate.parse(firstDay, dateFormat); 
}

public static int lengthOfCycle(Scanner input) {
system.out.print("Enter the length of your menstrual cycle: ");
return input.nextInt();
}

public static LocalDate ovulationDay(LocalDate, dateTimeFormatter, int length){
return firstDay.plusDays(length - 14);
}

public static LocalDate[] fertileDate(LocalDate, ovulationDate) {
LocalDate beginFertile = ovulationDate.minusDays(5);
LocalDate endFertile = ovulationDate.plusDays(1);
return new LocalDate[](beginFertile[0], endFertile[1]);
}

public static void result(Localdate ovulationDate, LocalDate[] fertile, dateTimeFormatter, dateFormat){
System.out.println("\nYour next ovulation date is: " + ovulationDate.format(dateFormat));

System.out.println("If there is no fertilization, your hormones level start dropping from:" + fertile[0].format(dateFomat) + " to " + fertile[1].format(dateFormat));

}

public static Boolean toContinue(Scanner input) {

String userChoice;
	
do {
	System.out.println("\nDo you want to continue (yes or no): ");
	userChoice = input.nextLine().trim().toLowerCase();
	
	if (userChoice.equals("yes")) {
	return true;
	} else if (userChoice.equals("no")) {
	return false;
	}
	else {
		System.out.println("Invalid input, Enter (yes or no)");
	}
} while (true);

}

}