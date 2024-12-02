package slidingwindow.getEqualTwoStr_1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetEqualTwoStrMaxFlipLen {
    
    public static int equalSubstring(String s, String t, int maxCost) {
        int maxLen=0;
        int windowStart=0;
        int currCost=0;
        for(int windowEnd=0;windowEnd<s.length();windowEnd++)
        {
            currCost+= Math.abs(s.charAt(windowEnd) - t.charAt(windowEnd));

            while(currCost > maxCost)
            {
                currCost-= Math.abs(s.charAt(windowStart) - t.charAt(windowStart));
                windowStart++;
            }
        maxLen = Math.max(maxLen, windowEnd-windowStart+1);
        }
        return maxLen;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String inputStrOne = bin.readLine();
        String inputStrTwo = bin.readLine();
        int maxCost = Integer.parseInt(bin.readLine());
        int maxLen = equalSubstring(inputStrOne,inputStrTwo,maxCost);
        System.out.println(maxLen);
    }
}
