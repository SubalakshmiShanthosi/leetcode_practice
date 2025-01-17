package binarysearch.searchInsertPos_35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchInsertPosOfX {
    
    private static int searchInsert(int[]nums, int target)
    {
        int resultIndex= nums.length;
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]>=target)
            {
                resultIndex=mid;
                high = mid -1;
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(bin.readLine().trim());
        int index = searchInsert(inputArr,x);
        System.out.println(index);
    }
}
