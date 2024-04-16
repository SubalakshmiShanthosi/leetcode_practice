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

1. Kandene Algorithm - Linear O(n)
   
   Hold two variables max_so_far and max_ending_here --> 
   Where max_so_far is maximum contiguous sum so far
   max_ending_here is sum till traversing current index i from beginning

   Idea here is to neglect negative value max_ending_here sum and hold maximum sum at max_so_far at each iteration step 

   

```java
import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        for(int index=0;index<nums.length;index++)
        {
            max_ending_here  = max_ending_here  + nums[index];
            
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            
            if(max_ending_here <0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
}
   
```