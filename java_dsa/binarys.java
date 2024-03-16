import java.util.*;
public class binarys {

    static int orderagnosticbs(int[]a, int x){
        int start = 0;
        int end = a.length - 1;
        boolean isAsc = a[start] > a[end];


        while(start <= end){
            int mid = start + ((end - start)/2);

            if(x == a[mid]){
                return mid;
            }

            else if (isAsc){    //array is ascending in order
                if(x < a[mid]){
                    end = mid - 1;
                }
                else if (x > a[mid]){
                    start = mid + 1;
                }

                else{
                    return -1; //element not found
                }
            }

            else{
                if(x > a[mid]){     //arrau is descending on order
                    end = mid - 1;
                }
                else if (x < a[mid]){
                    start = mid + 1;
                }

                else
                return -1;
            }
        }
        return -1;
    }
    static int bs(int [] a, int x){
        int start = 0;
        int end = a.length - 1;

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
        return -1;
    }

    public static void main(String args[]){
        int[] b = {1,2,3,4,5,6,7,8,9,10,11};
        int[] c = {9,8,7,6,5,4,3,2,1};
        int z;
        Scanner sc = new Scanner (System.in);
        z = sc.nextInt();
        int ans = orderagnosticbs(c, z);
        System.out.println(ans);
    }
    
}
