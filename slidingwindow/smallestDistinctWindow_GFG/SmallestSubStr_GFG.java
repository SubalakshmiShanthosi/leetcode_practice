package slidingwindow.smallestDistinctWindow_GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SmallestSubStr_GFG {
    
    private static int findSubString(String inpString)
    {
        int windowStart=0;
        int minLen = inpString.length();
        Map<Character,Integer> charFreqHMap = new HashMap<Character,Integer>();
        HashSet<Character> hashSetCharUnique = new HashSet<Character>();
        for(char aChar : inpString.toCharArray())
        {
            hashSetCharUnique.add(aChar);
        }
        int count =0;
        for(int windowEnd=0; windowEnd<inpString.length();windowEnd++)
        {
            char inChar = inpString.charAt(windowEnd);
            charFreqHMap.put(inChar, charFreqHMap.getOrDefault(inChar, 0)+1);
            if(charFreqHMap.get(inChar)==1)
                count++;
            while(windowStart<inpString.length() && count == hashSetCharUnique.size())
            {
                minLen = Math.min(minLen, windowEnd- windowStart+1);
                charFreqHMap.put(inpString.charAt(windowStart),charFreqHMap.getOrDefault(inpString.charAt(windowStart),0)-1);
                if(charFreqHMap.get(inpString.charAt(windowStart))==0)
                    count--;
                windowStart++;
            }
        }  
        return minLen;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = bin.readLine();
        //int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int minLenSubStr = findSubString(inputStr);
        System.out.println(minLenSubStr);
    }
}
