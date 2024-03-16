import java.util.*;

public class ATM2 {
    static Scanner sc = new Scanner(System.in);
    int PIN = 123;
    double amount, balance = 0;

    boolean check_credentials(int a) {
        if (a != PIN) {
            return false;
        } else {
            return true;
        }
    }

    void amount_deposition() {
        System.out.println("ENTER THE AMOUNT TO BE DEPOSITED : ");
        amount = sc.nextDouble();
        balance = balance + amount;
        System.out.println("NEW BALANCE : " + balance);
    }

    void amount_withdrawal() {
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

    void checking_info() {
        System.out.println("ACCOUNT NUMBER : 232456");
        System.out.println("BAKANCE AMOUNT : " + balance);
    }

    void pin_update() {
        int a = 3;
        while (a > 0) {
            int old_pin, new_pin, con_pin;
            System.out.println("ENTER YOUR OLD PIN : ");
            old_pin = sc.nextInt();
            if (check_credentials(old_pin) == true) {
                System.out.println("ENTER YOUR NEW PIN : ");
                new_pin = sc.nextInt();
                System.out.println("CONFIRM YOUR PIN : ");
                con_pin = sc.nextInt();
                if (new_pin == con_pin) {
                    PIN = new_pin;
                    System.out.println("PIN UPDATED");
                    break;
                } else {
                    System.out.println("CONFIRMATION FAILED. PLEASE TRY AGAIN");
                    break;
                }

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
    }

    void exit() {
        System.out.println("THANK YOU FOR USING HDFC BANK.");
        System.exit(0);
    }

    void display() {
        System.out.println("WELCOME TO HDFC BANK");
        System.out.println("1. AMOUNT DEPOSITION");
        System.out.println("2. AMOUNT WITHDRAWAL");
        System.out.println("3. CHECKING INFO");
        System.out.println("4. PIN UPDATE");
        System.out.println("5. EXIT");
    }

    public static void main(String args[]) {
        ATM2 ob = new ATM2();
        int pin;
        int attempts = 3;

        System.out.println("ENTER PIN: ");
        pin = sc.nextInt();
        while (attempts > 0) {
            if (ob.check_credentials(pin)) {
                System.out.println("ACCESS GRANTED.");
                do {
                    ob.display();
                    System.out.println("ENTER CHOICE : ");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            ob.amount_deposition();
                            break;
                        case 2:
                            ob.amount_withdrawal();
                            break;
                        case 3:
                            ob.checking_info();
                            break;
                        case 4:
                            ob.pin_update();
                            break;
                        case 5:
                            ob.exit();
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } while (true);
            } else {
                attempts--;
                if (attempts != 0) {
                    System.out.println("INVALID CREDENTIALS. NUMBER OF ATTEMPTS LEFT: " + attempts);
                    System.out.println("ENTER PIN: ");
                    pin = sc.nextInt();
                } else {
                    System.out.println("MAXIMUM NUMBER OF TRIES REACHED");
                    System.exit(0);
                }
            }
        }
    }
}
