import java.util.*;

public class StudentGrade {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);

System.out.print("How many students do you have?: ");
int numberOfStudent = input.nextInt();

System.out.print("How many subject do they offer?: ");
int numberOfSubject = input.nextInt();

String[] studentName = new String[numberOfStudent];
int[][] studentScore = new int [numberOfStudent][numberOfSubject];
int[] total = new int[numberOfStudent];
double[] average = new double[numberOfStudent];
int[] position = new int[numberOfStudent];

for (int counter = 0; counter < numberOfStudent; counter++) {
    System.out.print("Enter names of student " + (counter + 1) + ": ");
    studentName[counter] = input.next();

    int totalScore = 0;

    for (int count = 0; count < numberOfSubject; count++) {
        int score;

        do {
            System.out.print("Enter score for " + studentName[counter] + " in subject " + (count + 1) + " (0-100): ");
            score = input.nextInt();
        } while (score < 0 || score > 100);

        studentScore[counter][count] = score;
        totalScore += score;
    }

    total[counter] = totalScore;
    average[counter] = totalScore / (double) numberOfSubject;
}
}
}
