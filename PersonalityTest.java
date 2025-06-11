import java.util.Scanner;

public class PersonalityTest {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

System.out.println("What is your name");
String name = input.nextLine();
        
String[][] questions = {
            {"A. tough minded, just", "B. tender-hearted, merciful", "B"},
            {"A. candid, straight forward, frank", "B. tactful, kind, encouraging", "B"},
            {"A. focus on here-and-now", "B. look to the future, global perspective, big picture", "F"},
            {"A. control, govern", "B. latitude, freedom", "B"},
            {"A. standard, usual, conventional", "B. different, novel, unique", "A"},
            {"A. external communicative, express yourself", "B. internal, reticent, keep to yourself", "A"},
            {"A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate", "B"},
            {"A. matter of fact, issue-oriented", "B. sensitive, people-oriented, compassionate", "B"},
            {"A. preparation, plan ahead", "B. go with the flow, adapt as you go", "A"},
            {"A. Interpret literally", "B. look for meaning and possibilities", "B"},
            {"A. organized, orderly", "B. flexible, adaptable", "B"},
            {"A. seek many tasks, public activities, interactive with other", "B. seek private, solitary activities with quiet to concentrate", "A"},
            {"A. more outgoing, think out loud", "B. more reserved, think to yourself", "B"},
            {"A. practical, realistic, experiential", "B. imaginative, innovative, theoretical", "B"},
            {"A. regulated, structured", "B. easy going, live and let live", "A"},
            {"A. plan, schedule", "B. unplanned spontaneous", "B"},
            {"A. facts things, what is", "B. ideas, dreams, what could be, philosophical", "B"},
            {"A. expend energy, enjoy groups", "B. conserve energy, enjoy one-on-one", "B"},
            {"A. active, initiate", "B. reflective, deliberate", "B"},
            {"A. logical, thinking, questioning", "B. empathetic, feeling, accommodating", "B"}
        };

       
int countA = 0;
int countB = 0;

System.out.println();
       
for (int counter = 0; counter < questions.length; counter++) {
	System.out.println(questions[counter][0]);
	System.out.println(questions[counter][1]);
	System.out.print("Enter answer (A or B): ");
	String answer = input.nextLine().trim().toUpperCase();

            
	if (answer.equals("A") || answer.equals("B")) {
	if (answer.equals("A") && questions[counter][2].equals("A")) {
		countA++;
	} else if (answer.equals("B") && questions[counter][2].equals("B")) {
		countB++;
                }
	} else {
		System.out.println("Expected A or B as Response");
		System.out.println("I know this is an error, Please retry again");
			counter--;
            }
        }
System.out.println();
System.out.println("Hello " + name + " You selected");
System.out.println("Number of A selected: " + countA);
System.out.println("Number of B selected: " + countB);
	
    }
}
