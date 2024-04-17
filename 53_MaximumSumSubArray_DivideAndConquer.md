# 53 Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum.

```md
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
```

**Approaches**

1. Divide and Conquer  
   Time complexity of this approach is O(nLogn)
   Divide the array into three portions
        Find left half sum (start --> middle)
        Find right half sum (middle+1 --> high)
    Return Max of left_sum+right_sum - arr[middle] and left_sum + right_sum
   
   

```java
import java.util.*;
class Solution {

    public int maxCrossingSum(int[]nums, int left,int middle,int right)
    {
        // Include elements on left of mid. 
        int sum = 0; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = middle; i >= left; i--) { 
            sum = sum + nums[i]; 
            if (sum > left_sum) 
                left_sum = sum;
        }
        sum=0;
        int right_sum = Integer.MIN_VALUE; 
        for(int i=middle;i<=right;i++){
            sum = sum + nums[i];
            if(sum > right_sum) 
                right_sum = sum; 

        }
        return Math.max(left_sum + right_sum - nums[middle], 
                        Math.max(left_sum, right_sum)); 
        
    }

    public int maxSumSubArray(int[] nums,int left,int right)
    {
        if(left==right)
            return nums[left];
        if(left>right)
            return Integer.MIN_VALUE;
        int middle = (left+right)/2;
        return Math.max( 
            Math.max(maxSumSubArray(nums, left, middle-1), 
                     maxSumSubArray(nums, middle + 1, right)), 
            maxCrossingSum(nums, left, middle, right));  
    }
    public int maxSubArray(int[] nums) {
         int max_sum = maxSumSubArray(nums, 0, nums.length - 1); 
         return max_sum;
}
}

```