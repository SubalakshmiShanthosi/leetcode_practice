# 438 - Find All Anagrams of String
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

**Example 1:**

```
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

```

**Example 2:**

```
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

Approach - Sliding Window Pattern

- Step 0 - Hold Hashmap with pattern characters frequency - Example 1 HashMapCharFreq will contain 

    a - 1
    b - 1
    c - 1
- Step 1 - Sliding WindowStart and windowEnd two sliding pointers starting with index 0 

        Get character aChar -> charAt(slidingWindowStart)
        Check if HMap created at step1 contains aChar
        If So decrement it's char freq on HMAP by 1 

        If CharHMap doesn't have charFreq of aChar ==> matched flag +1 

        If matched == charHMap.size() => Then add starting index

        If windowEnd >= pattern.length - 1 meaning we are about to slide a sequence length as that of pattern
            Time to increment startingIndex 
            Check if thischar is in  HMap 
                If already found on HMap and it's freq is zero 
                    matched -- 
                Increment it's frequency on charHMap by 1