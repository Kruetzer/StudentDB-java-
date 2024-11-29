import java.util.Scanner;

abstract class Transaction {
    static double balance = 0;

    public void deposit() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Deposit Amount: ");
        double depositAmount = scan.nextDouble();

        balance += depositAmount;
        System.out.println("Deposit Successful" + balance);
    }

    public void checkBalance() {
        System.out.println("Your Balance is: " + balance);
    }

    public void withdraw() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Amount to Withdraw: ");
        double withdrawAmount = scan.nextDouble();

        if (withdrawAmount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= withdrawAmount;
            System.out.println("P" + withdrawAmount + "Withdrawal Successful");
        }
        scan.close();
    }
}

class User extends Transaction {
    public void CreateAccount() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter AccountNumber: ");
        int accNumber = scan.nextInt();

    }
}

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            User user = new User();

            System.out.printf("%nRuben Bank%n"
                    + "1. Create Account%n"
                    + "2. Withdraw%n"
                    + "3. Deposit%n"
                    + "4. Check Balance%n"
                    + "5. Exit%n");
            int selection = input.nextInt();

            switch (selection) {
                case 1:
                    user.CreateAccount();
                    break;
                case 2:
                    user.withdraw();
                    break;
                case 3:
                    user.deposit();
                    break;
                case 4:
                    user.checkBalance();
                    break;

            }
        }

    }

}
