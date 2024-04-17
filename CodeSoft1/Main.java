import java.util.Scanner;

class Range{
    public int generate(int max, int min){
        return(int)(Math.random()*(max - min + 1) + min);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Range rg = new Range();
        int totalAttempts = 0;
        int win = 0;
        System.out.println("Welcome!! Let's Play The Game.");
        while(true){
            System.out.println("Enter the Maximum Number: ");
            int max = sc.nextInt();
            System.out.println("Enter the Minimum Number: ");
            int min = sc.nextInt();
            sc.nextLine();

            int cnum = rg.generate(max, min);
            int attempts = 0;

            while(true){
                System.out.println("Guess a number between " +max+ " and " +min);
                int gnum = sc.nextInt();
                attempts++;

                if(gnum > cnum){
                    System.out.println("It's high Guess");
                }
                else if(gnum < cnum){
                    System.out.println("It's Low Guess");
                }
                else{
                    System.out.println("Correct Guess!! You Won.");
                    win++;
                    break;
                }
            }
            totalAttempts += attempts;
            System.out.println("Attempts = " +attempts);
            System.out.println("Wins = " +win);

            double winrate = (double) win/totalAttempts*100;
            System.out.println("Your WinRate is " +winrate+ " %");

            System.out.println("Do you want to play again (Yes/No)");
            String playAgain = sc.next();
            if(!playAgain.equalsIgnoreCase("Yes")){
                System.out.println("Thank You!! Hope you enjoyed it.");
                sc.close();
                System.exit(0);
            }
            sc.nextLine();
        }
    }
}
