package slidingwindow.longSubStrWithKDistChar_340;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongSubStrWithKDistChar {
    
    public static int maxLenKDistCharStr(String inputString, int k){
        int maxLen=0;
        Map<Character,Integer> charOccurHMap = new HashMap<Character,Integer>();
        int windowStart=0;
        for(int windowEnd=0;windowEnd<inputString.length();windowEnd++)
        {
            char currentChar = inputString.charAt(windowEnd);
            charOccurHMap.put(currentChar, charOccurHMap.getOrDefault(currentChar, 0)+1);
            if(charOccurHMap.size()> k)
            {
                //Shrink sliding window
                char leftChar = inputString.charAt(windowStart);
                charOccurHMap.put(leftChar, charOccurHMap.getOrDefault(leftChar, 0)-1);
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd-windowStart+1);
        }
        return maxLen;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bin.readLine();
        int k = Integer.parseInt(bin.readLine());
        int maxLen = maxLenKDistCharStr(inputString,k);
        System.out.println(maxLen);
    }
}
