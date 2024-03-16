import java.util.*;

public class ATM {
    String USERNAME = "abc";
    int PIN = 123;
    double amount, balance = 0;

    boolean check_credentials(int b) {
        if (b == PIN)
            return true;
        else {
            System.out.println("INVALID CREDENTIALS");
            return false;
        }

    }

    void atm_functions() {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO HDFC BANK");
        System.out.println("1. AMOUNT DEPOSITION");
        System.out.println("2. AMOUNT WITHDRAWAL");
        System.out.println("3. CHECKING INFO");
        System.out.println("4. PIN UPDATE");
        System.out.println("5. EXIT");
        System.out.println("ENTER YOUR CHOICE");
        choice = sc.nextInt();

        switch (choice) {
            case 1: {
                System.out.println("ENTER THE AMOUNT TO BE DEPOSITED : ");
                amount = sc.nextInt();
                balance = balance + amount;
                System.out.println("NEW BALANCE : " + balance);
            }
                break;

            case 2: {
                double withdraw = 0;
                System.out.println("ENTER THE AMOUNT TO BE WITHDRAWN : ");
                withdraw = sc.nextDouble();
                if (withdraw > balance) {
                    System.out.println("INSUFFICIENT AMOUNTS");
                } else {
                    balance = balance - withdraw;
                    System.out.println("NEW BALANCE : " + balance);
                }
            }
                break;

            case 3: {
                System.out.println("NAME : " + USERNAME);
                System.out.println("ACCOUNT NUMBER : 12345454");
                System.out.println("TOTAL SAVINGS : " + balance);
            }
                break;

            case 4: {
                int a = 3;
                while (a > 0) {
                    int old_pin;
                    System.out.println("ENTER YOUR OLD PIN : ");
                    old_pin = sc.nextInt();
                    if (check_credentials(old_pin) == true) {
                        int new_pin;
                        System.out.println("ENTER YOUR NEW PIN : ");
                        new_pin = sc.nextInt();
                        PIN = new_pin;
                        System.out.println("PIN HAS BEEN UPDATED");
                        break;
                    } else {
                        a -= 1;
                        if (a != 0)
                            System.out.println("WRONG PIN. PLEASE TRY AGAIN. REMAINING ATTEMPTS : " + a);
                        else {
                            System.out.println("MAXIMUM NUMBER OF TRIES REACHED. PLEASE TRY AGAIN LATER.");
                            System.exit(0);
                        }
                    }
                }
                break;
            }

            case 5: {
                System.exit(0);
            }

        }

    }

    public static void main(String args[]) {
        ATM ox = new ATM();
        Scanner ob = new Scanner(System.in);
        int attempts = 3;
        while (attempts > 0) {
            int pin;
            System.out.println("ENTER YOUR PIN : ");
            pin = ob.nextInt();
            if (ox.check_credentials(pin) == true) {
                System.out.println("ACCESS GRANTED");
                ox.atm_functions();
            } else {
                attempts -= 1;
                if (attempts != 0)
                    System.out.println("ACCESS DENIED. ATTEMPTS REMAINING : " + attempts);
                else {
                    System.out.println("MAIMUM NUMBER OF TRIES REACHED. PLEASE TRY AGAIN LATER.");
                    System.exit(0);
                }
            }
        }
    }

}
