package slidingwindow.cntNoOfNiceSubArr_1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CntNoOfNiceSubArr {
    
    private static int numberOfSubarrays(int [] nums, int k)
    {
        return atMostHelperCntNiceArr(nums, k) - atMostHelperCntNiceArr(nums, k-1);
    }

    /*private static void printElementsInRange(int[] array, int start, int end) {
        if (start < 0 || end >= array.length || start > end) {
            System.out.println("Invalid index range.");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == start) {
                System.out.print("\033[37;1m"); // Start highlighting
            }

            System.out.print(array[i]);

            if (i == end) {
                System.out.print("\033[0m"); // End highlighting
            }

            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }*/
    private static int atMostHelperCntNiceArr(int [] nums,int k)
    {
        int result=0;
        int windowStart=0;
        int oddNosCnt = 0; 
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++)
        {   
            oddNosCnt+= nums[windowEnd]%2;

            while(oddNosCnt > k)
            {
                oddNosCnt -= nums[windowStart]%2;
                windowStart++;
            }
            result += (windowEnd - windowStart+1);
           //printElementsInRange(nums, windowStart, windowEnd);
        }
        
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(bin.readLine().trim());
        int result = numberOfSubarrays(inputArray,k);
        System.out.println(result);
    }
}
