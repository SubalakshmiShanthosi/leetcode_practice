package binarysearch.cntNoOfRotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CntNoOfRotationSortedArr {
    

    private static int findCntOfRotation(int[]nums)
    {
        int low = 0;
        int index=0;
        int high = nums.length-1;
        int lowAns = Integer.MAX_VALUE;

        while(low<high)
        {
            int mid = low + (high-low)/2;

            if(nums[low]<= nums[high])
            {
                if(nums[low]<lowAns)
                {
                    index=low;
                    lowAns = nums[low];
                }
                break;
            }
            else if (nums[low]<=nums[mid])
            {
                if(nums[low]<lowAns)
                {

                    index=low;
                    lowAns = nums[low];
                }
                low = mid+1;
            }
            else{
                high = mid-1;
                if(nums[mid]<lowAns)
                {
                    index = mid;
                    lowAns = nums[mid];
                }
            }

        }

        return index;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inpArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int resultNosCnt = findCntOfRotation(inpArr);
        System.out.println(resultNosCnt);
    }
}
