# 1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

```rb
Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
```

# Approach 
Sliding window with variable size window
Window shrink condition --> When arr[windowStart++]==0 and k < 0 -> Increment k

```rb
Loop from windowEnd 0 to arr.len
    Check if arr[windowEnd++] is zero 
            Decrement k
    Check if arr[windowStart++] is zero and k < 0 
            Increment k
End Loop
return windowEnd - windowStart
```
