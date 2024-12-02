package slidingwindow.subArrProdLessThanK_713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountSubArrProdLessThanK {
    
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int windowStart=0;
        int prod=1;
        int noOfSubArrProdLtK = 0;
        for(int windowEnd=0;windowEnd<nums.length; windowEnd++)
        {
            prod = prod * nums[windowEnd];
            while(windowStart <= windowEnd && prod >=k)
                {
                    prod = prod/nums[windowStart++];
                }
            noOfSubArrProdLtK = noOfSubArrProdLtK + (windowEnd - windowStart) +1;
        }
        return noOfSubArrProdLtK;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("//s+")).mapToInt(Integer::parseInt).toArray();
        int K = inputArray[inputArray.length-1];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-1);
        int result = numSubarrayProductLessThanK(inputArray,K);
        System.out.println(result);
    }
}
