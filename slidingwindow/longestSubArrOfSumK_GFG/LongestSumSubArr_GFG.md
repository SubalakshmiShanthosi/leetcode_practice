# Longest Sub-Array with Sum K
Given an array arr containing n integers and an integer k. Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value k.

```rb
Input :
arr[] = {10, 5, 2, 7, 1, 9}, k = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.


Input : 
arr[] = {-1, 2, 3}, k = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.

```
# Approach - Variable size sliding window
Since the array can contain negative numbers

Hold an hashMap with preFixSum, windowEnd position

windowLen=0,
Iterate from windowEnd 0 to ArrLen

    windowSum+= input[windowEnd]
    Check if windowSum == K
        compute maxLen = Math.max(maxLen,windowEnd+1);

    At every step of iteration compute - remSum => windowSum - K

    Check if remSum is in HMap 

        If so recompute maxLen = Math.max(maxLen, windowEnd - HMap.get(remSum))
        Check if HMap not contains remSum
            Add remSum, windowEnd to the HMap



