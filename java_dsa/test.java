import java.util.Scanner;

public class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int copy = n;
        
        
        int[] count = new int[10];

        while (copy > 0) {
            int d = copy % 10;
            count[d]++;
            copy = copy / 10;
        }

        
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                System.out.println("The occurrence of " + i + " is " + count[i]);
            }
        }
    }
}
