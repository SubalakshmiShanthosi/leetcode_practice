# Find the number of occurrences of an element in a sorted array

Given a sorted array of n elements, possibly with duplicates, find the number of occurrences of the target element.

```rb
Example 1:


Input: arr = [4, 4, 8, 8, 8, 15, 16, 23, 23, 42], target = 8
Output: 3
Example 2:


Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 6
Output: 0
Example 3:


Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 5
Output: 4
Expected O(logn) time solution.
```

# Approach 
Use Lower bound and upper bound to get first index and last index of occurance of target
Result ==> upperBnd - lowerBnd+1