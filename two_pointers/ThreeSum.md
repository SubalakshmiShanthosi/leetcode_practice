# 3 Sum Problem

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

```rb
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

```

# Approach


    First sort the entire array in ascending order

    Then Run one loop starting from i-> 0 to Arr.length        
        Check for equals of consecutive elements -> i!=0 && arr[i] == arr[i+1] 
                then continue i.e) skip the iteration i 
        Have pointer j=> i+1 , k => Arr.Length -1
        Check if Arr[i]+Arr[j]+Arr[k] == 0
                Then add entries to the result set 
                Increment j, decrement k
                Skip duplicates for consecutive indices of k and j
                
        Check if Arr[i]+Arr[j]+Arr[k] > 0
                Increment k
        Check if Arr[i] + Arr[j] + Arr[k] < 0
                Increment j
        
