# 154. Find Minimum in Rotated Sorted Array II

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

```rb
Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0
 
```

## Approach

Since the array is partially sorted - We will have to check if the first,mid, mid and high comparision 
If mid and high are equal  --> high -=1

low <- 0
high <- arr.length -1 

while low < high 
    mid <- low + (high - low)/2
    if arr[low] < arr[mid]
            high = mid
    else if arr[mid] > arr[high]
            low = mid +1
    else 
        high = high -1

return arr[high]
