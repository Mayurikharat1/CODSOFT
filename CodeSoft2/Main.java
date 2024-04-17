import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Subject: ");
        int subjectNum = sc.nextInt();

        if(subjectNum <= 0){
            System.out.println("Please Enter Valid Number of Subject");
            return;
        }
        int totalMarks = 0;
        int maxMarksPerSubject = 100;

        System.out.println("Enter Marks Obtained in each Subject (out of 100) : ");

        for(int i=1; i<=subjectNum; i++){
            System.out.println("Enter Marks For Subject " +i+ " :");
            int Marks = sc.nextInt();

            if(Marks < 0 || Marks > maxMarksPerSubject){
                System.out.println("Please Enter Valid marks. Invalid Input!!");
                i--;
            }
            else{
                totalMarks += Marks;
            }        
        }

        double averagePercentage = (double) totalMarks / (subjectNum *maxMarksPerSubject)*100;

        String grade;
        if(averagePercentage >= 90){
            grade = "A+";
        }
        else if(averagePercentage >= 80){
            grade = "A";
        }
        else if(averagePercentage >= 70){
            grade = "B";
        }
        else if(averagePercentage >= 60){
            grade = "C";
        }
        else if(averagePercentage >= 50){
            grade = "D";
        }
        else{
            grade = "F";
        }
        
        System.out.println("\n" +ANSI_BOLD+ "-------------Result-------------" +ANSI_RESET);
        System.out.println("Total Marks: " +totalMarks);
        System.out.println("Average Percentage: " +averagePercentage+ " %");
        System.out.println("Grade: " +grade);
        System.out.println(ANSI_BOLD+ "---------------------------------" +ANSI_RESET);
    }
}