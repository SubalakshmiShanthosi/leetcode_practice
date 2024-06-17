# 2653 - Sliding SubArray Beauty

Given an integer array `nums` containing `n` integers, find the **beauty** of each subarray of size `k`.

The **beauty** of a subarray is the `x^th^` **smallest integer** in the subarray if it is **negative**, or `0` if there are fewer than `x` negative integers.

Return *an integer array containing* `n - k + 1` *integers, which denote the* **beauty** *of the subarrays **in order** from the first index in the array.*

-   A subarray is a contiguous **non-empty** sequence of elements within an array.

```rb
Example 1:

Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
Output: [-1,-2,-2]
Explanation: There are 3 subarrays with size k = 3. 
The first subarray is [1, -1, -3] and the 2nd smallest negative integer is -1. 
The second subarray is [-1, -3, -2] and the 2nd smallest negative integer is -2. 
The third subarray is [-3, -2, 3] and the 2nd smallest negative integer is -2.

```

Approach - Sliding Window Approach with TreeMap to hold all negative numbers
