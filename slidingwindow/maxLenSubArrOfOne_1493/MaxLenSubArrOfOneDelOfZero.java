package slidingwindow.maxLenSubArrOfOne_1493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxLenSubArrOfOneDelOfZero {
 
    public static int longestSubarray(int[] inputArray)
    {
        int windowStart=0;
        int windowEnd=0;
        int k=1;
        while (windowEnd < inputArray.length) {
            if(inputArray[windowEnd++] == 0)
                k--;
            if(k<0 && inputArray[windowStart++]==0)
                k++;
        }
         
        return windowEnd - windowStart - 1; 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int resultLen = longestSubarray(inputArr);
        System.out.println(resultLen);
    }
}
