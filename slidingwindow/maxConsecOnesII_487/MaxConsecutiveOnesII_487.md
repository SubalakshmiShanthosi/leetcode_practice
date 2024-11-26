# 487. Max Consecutive Ones II
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

```rb
Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.

```

Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

# Approach 
Sliding window with variable window Size
Start with windowStart,windowEnd=0, numOfZeroFlipAll=1

```rb
While windowEnd< arr.length 
    if(arr[windowEnd++]==0)
        numOfZeroFlipAll--;
    if(numOfZeroFlipAll <  0 && arr[windowStart++] == 0)
        numOfZeroFlipAll++;
End While
Return windowEnd - windowStart
```