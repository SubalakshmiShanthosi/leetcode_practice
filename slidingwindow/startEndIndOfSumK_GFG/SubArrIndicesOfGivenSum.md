# Indexes of Subarray Sum - GeeksForGeeks

Given an unsorted array arr of size n that contains only non negative integers, find a sub-array (continuous elements) that has sum equal to s. You mainly need to return the left and right indexes(1-based indexing) of that subarray.

In case of multiple subarrays, return the subarray indexes which come first on moving from left to right. If no such subarray exists return an array consisting of element -1.

```rb
Input: arr[] = [1,2,3,7,5], n = 5, s = 12
Output: 2 4
Explanation: The sum of elements from 2nd to 4th position is 12.


Input: arr[] = [5,3,4], n = 3, s = 2
Output: -1
Explanation: There is no subarray with sum 2

Input: arr[] = [7,2,1], n = 3, s = 2
Output: 2 2
Explanation: The sum of elements from 2nd to 2nd position is 2.

Input: arr[] = [1,2,3,4,5,6,7,8,9,10], n = 10, s = 15,
Output: 1 5
Explanation: The sum of elements from 1st to 5th position is 15.

```


# Approach 
Sliding window with variable size window size 

Here check for windowSum >= s 

    If so shrink the sliding window

    Remove elements from windowSum (indexces windowStart --> ith position) till the position at which windowSum exceeds s

    Increment windowStart
Check if windowSum == s 


    Add windowStart+1 windowEnd+1 indices in result


