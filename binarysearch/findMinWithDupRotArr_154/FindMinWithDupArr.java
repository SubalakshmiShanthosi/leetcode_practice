package binarysearch.findMinWithDupRotArr_154;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindMinWithDupArr {
    

    private static int findMinWithDup(int[]nums)
    {
        int low=0;
        int high = nums.length-1;
        while (low< high) {
            int mid = low +(high-low)/2;
            if(nums[low]< nums[mid])
                high = mid;
            else if(nums[mid]>nums[high])
                low = mid+1;
            else 
                high = high-1;
        }
        return nums[high];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int minElement = findMinWithDup(inputArr);
        System.out.println(minElement);
    }
}
