package binarysearch.searchInRotatedArr_33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchInRotatedSortArr {
    
    private static int search(int[] nums, int target)
    {
        int searchIndex=-1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high])

                    low = mid + 1;

                else

                    high = mid - 1;
                }
            }
        

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inpArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(bin.readLine().trim());
        int searchIndex = search(inpArr,target);
        System.out.println(searchIndex);
    }
}
