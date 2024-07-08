# 904. Fruits into Basket
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 ```rb
Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 
 ```

**Solution:**
 This problem can be handled with sliding window with variable size length.
 Initialize windowStart=0, maxLen=0
 Loop from windowEnd = 0 to length of array
 Maintain an HashMap as additional datastructure to hold the fruits[i], it's occurance in the list
    Constraint here is to have only K=2 Distinct Fruits
        Check if hashMap size > 2 --> This is the shrink condition for sliding window 
            Shink by decrementing occurance of fruits[windowStart] 
            If hashMap get for fruits[windowStart] is zero remove this key from HashMap
            WindowStart is incremented by 1. 

    Compute maxLen at each iteration --> Math.max(maxLen, windowEnd - windowStart +1)

