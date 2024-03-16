import java.util.*;
public class ceilingLetter {

    static int findCeilingLetter(char[]a, char x){
        int start = 0;
        int end = a.length - 1;

        if(x > a[a.length - 1]){        // what if target value is greater than greatest number in the array
            return -1;
        }

        while (start <= end)
        {
            int mid = start + ((end - start)/2);

            if (x < a[mid]){
                end = mid - 1;
            }

            else if (x > a[mid]){
                start = mid + 1;
            }

            else{
                return mid;
            }
        }
        return a[start % a.length];
    }

    public static void main(String args[]){
        char[] c = {'c', 'f', 'j'};
        char z;
        Scanner sc = new Scanner (System.in);
        z = 'a';
        int ans = findCeilingLetter(c, z);
        System.out.println((char)ans);
    }
    
}
