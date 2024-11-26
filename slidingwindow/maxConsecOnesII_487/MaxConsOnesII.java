package slidingwindow.maxConsecOnesII_487;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxConsOnesII {
    
    public static int findMaxConsecutiveOnes(int[]inputArray)
    {
        //Result of max consecutive ones
       
        int windowEnd=0,windowStart=0, numOfZeroAllowed=1;
        while(windowEnd<inputArray.length)
        {
            if(inputArray[windowEnd++]==0)
                numOfZeroAllowed--;
            
            if(numOfZeroAllowed<0 && inputArray[windowStart++]==0)
                windowStart++;
        }

        return windowEnd-windowStart;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int result = findMaxConsecutiveOnes(inputArray);
    }
}
