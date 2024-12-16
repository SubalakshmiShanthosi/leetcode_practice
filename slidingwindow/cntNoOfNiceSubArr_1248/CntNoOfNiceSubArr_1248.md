# 1248. Count Number of Nice Subarrays

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

```rb
Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 
```

## Approach

Sliding window with atMost equal K approach
Helper function will run from windowEnd <- 0 to arr.length
    Calculate arr[windowEnd] % 2 and sum it => winSum. (For non even numbers it's value is always not zero)
    Shrink window when the condition of noOf Odd Nums exceeds k meaning winSum > k
       winSum minus arr[windowStart] % 2
       windowStart++
    At every iteration calculate result ==> result + windowEnd - windowStart+1
    Return result

For Atmost equal K
        Call Helper function with parameters atMosthelper( nums[],k ) - atMosthelper(nums[],k-1)
