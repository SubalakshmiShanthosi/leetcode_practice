# Subarray with 0 sum
Given an array of integers. Find if there is a subarray (of size at-least one) with 0 sum. You just need to return true/false depending upon whether there is a subarray present with 0-sum or not. Printing will be taken care by the driver code.

```rb
Example 1:
Input:
n = 5
arr = {4,2,-3,1,6}
Output: 
Yes
Explanation: 
2, -3, 1 is the subarray with sum 0.

Example 2:

Input:
n = 5
arr = {4,2,0,1,6}
Output: 
Yes
Explanation: 
0 is one of the element in the array so there exist a subarray with sum 0.

```

# Approach - Variable Size Sliding window
Maintain hashSet with integers (windowSum)
If you get the hashSet containing a particular windowSum seen before - This means that zero sum is possible return true
If you encounter arr[i] as zero return true
If current computation of windowSum is zero return true

If none of the three conditions above are met return false