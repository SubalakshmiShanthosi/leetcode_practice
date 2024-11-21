# 159. Longest Substring with At Most Two Distinct Characters

The problem provides us with a string s and asks us to determine the length of the longest substring which contains at most two distinct characters. For example, in the string "aabacbebebe," the longest substring with at most two distinct characters is "cbebebe," which has a length of 7.

# Approach 
Sliding Window with Variable window size
Window size altering condition --> Maintain an HashMap to calculate the distinct number of characters and it's corresponding number of occurances in the string. 
Sliding window Shrink condition --> HashMap should not have more than 2 distinct characters (or) hashMap.size()>2 shrink the sliding window 

How shrinking is done? Remove the character one after another from windowStart until hashMap.size() > 2 
    If the hashMap.get(windowStartChar) == 0 
            remove the char from hashMap
    increment windowStart
Calculate maxLen <- Math.max(windowEnd-windowStr+1,maxLen)

