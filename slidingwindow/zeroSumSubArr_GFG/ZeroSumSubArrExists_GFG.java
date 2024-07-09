package slidingwindow.zeroSumSubArr_GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class ZeroSumSubArrExists_GFG {
    
    private static boolean findsum(int[] inputArr)
    {
        long windowSum=0;
        Set<Long> windowSumHashSet = new HashSet<Long>();
        for(int windowEnd=0;windowEnd<inputArr.length;windowEnd++)
        {
            windowSum+=inputArr[windowEnd];

            if(!windowSumHashSet.contains(windowSum))
                windowSumHashSet.add(windowSum);
            
            if(inputArr[windowEnd]==0 || windowSumHashSet.contains(windowSum) || windowSum==0)
                return true;
            
            

        }

        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean result = findsum(inputArr);
        System.out.println(result);
    }
}
