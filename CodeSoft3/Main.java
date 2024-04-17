import java.util.Scanner;

class BankAccount{
    private int balance;
    public BankAccount(int initialAmount){
        this.balance = initialAmount;
    }
    public int balance(){
        return balance;
    }
    public void deposit(int amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Amount of " + amount + " Rs. was deposit successfully.");
        }
        else{
            System.out.println("Invalid entry!! Please enter a valid amount.");
        }
    }

    public void withdraw(int amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println(+amount+ " Rs. Withdraw successfully.");
        }
        else{
            System.out.println("Insufficient Balance. Invalid Entry!");
        }
    }
}
class ATM{
    private BankAccount account;
    public ATM(BankAccount account){
        this.account = account;
    }

    public void display(){
        System.out.println("Select any one Option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            display();
            System.out.println("Choose an option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Current Balance " + account.balance());
                    break;
                case 2:
                    System.out.println("Enter amount to Deposit: ");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to Withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank You!!");
                    break;
                default:
                    System.out.println("Invalid Entry. Enter the correct option.");
            }
        }while(option != 4);
        sc.close();
    }
}
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount( 50000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
