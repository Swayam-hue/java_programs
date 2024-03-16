import java.util.*;
public class ceiling {

    static int findCeiling(int[]a, int x){
        int start = 0;
        int end = a.length - 1;

        if(x > a[a.length - 1]){ // what if target value is greater than greatest number in the array
            return -1;
        }

        while (start<=end){
            int mid = start + ((end - start)/2);

            if (x<a[mid]){
                end = mid - 1;
            }

            else if (x>a[mid]){
                start = mid + 1;
            }

            else{
                return mid;
            };
        }
        return start;
    }

    public static void main(String args[]){
        int[] b = {1,2,3,4,5,6,7,8,9,10,11};
        int[] c = {2,3,5,9,14,16,18};
        int z;
        Scanner sc = new Scanner (System.in);
        z = sc.nextInt();
        int ans = findCeiling(c, z);
        System.out.println(ans);
    }
    
}
