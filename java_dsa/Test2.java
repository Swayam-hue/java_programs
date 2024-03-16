import java.util.Scanner;

public class Test2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int copy = n;

        while (copy > 0) {
            int digit = copy % 10;
            int count = 0;
            int copy1 = n;

            while (copy1 > 0) {
                int currentDigit = copy1 % 10;
                if (currentDigit == digit) {
                    count++;
                }
                copy1 /= 10;
            }

            // Display the occurrence only if it hasn't been displayed before
            if (count > 0) {
                System.out.println("The occurrence of " + digit + " is " + count);
            }

            // Set the count to 0 for the next unique digit
            copy /= 10;
        }
    }
}
