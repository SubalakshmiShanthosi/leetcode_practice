# Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

Assume that there is exactly only **one solution** and you may not use the same element twice.

```coffee
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

Methodology for solving in O(n) -->

Additional space by having HashMap -
        Iterate once of the array
        Find target - array[index] exists on HMap?
        If
            Found then return the HMap(temp) and index as result
        Else
            Add array[index], index to HMap.

```java
import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> elementHMap = new HashMap<Integer,Integer>();
        int[] resultIndices = new int[2];
        for(int index=0;index<nums.length;index++)
        {
           int temp = target-nums[index];
           if(!elementHMap.containsKey(temp))
           {
                elementHMap.put(nums[index],index);
           }
           else{
               resultIndices[0]= elementHMap.getOrDefault(temp,0);
               resultIndices[1] = index;
           }
        }
        return resultIndices;
    }
}
```
