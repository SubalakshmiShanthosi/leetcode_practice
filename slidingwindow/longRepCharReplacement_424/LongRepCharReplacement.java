package slidingwindow.longRepCharReplacement_424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongRepCharReplacement {
    
    public static int characterReplacement(String input, int k)
    {
        int windowStart=0;
        Map<Character,Integer> charOccurHMap = new HashMap<>();
        int max_len=0,max_freq=0;
        for(int windowEnd=0;windowEnd<input.length();windowEnd++)
        {
            charOccurHMap.put(input.charAt(windowEnd),charOccurHMap.getOrDefault(input.charAt(windowEnd), 0)+1);
            max_freq = Collections.max(charOccurHMap.values());
            
            if( (windowEnd-windowStart +1)- max_freq > k )
            {
                charOccurHMap.put(input.charAt(windowStart), charOccurHMap.getOrDefault(input.charAt(windowStart), 0)-1);
                windowStart++;
            }
            max_len = Math.max(max_len, windowEnd-windowStart+1);

        }


        return max_len;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String input = bin.readLine();
        int k = Integer.parseInt(bin.readLine());
        int numOfCharToReplace = characterReplacement(input, k);
        System.out.println(numOfCharToReplace);
    }
}
