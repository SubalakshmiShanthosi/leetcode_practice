package slidingwindow.maxConsecOnesIII_1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxConsecOnesIII {
      public static int findMaxConsecutiveOnes(int[]inputArray, int k)
    {
        //Result of max consecutive ones
       
        int windowEnd=0,windowStart=0;
        while(windowEnd<inputArray.length)
        {
            if(inputArray[windowEnd++]==0)
                k--;
            
            if(k<0 && inputArray[windowStart++]==0)
                k++;
        }

        return windowEnd-windowStart;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = inputArray[inputArray.length-1];
        inputArray= Arrays.copyOf(inputArray, inputArray.length-1);
        int result = findMaxConsecutiveOnes(inputArray,k);
        System.out.println(result);
    }

}
