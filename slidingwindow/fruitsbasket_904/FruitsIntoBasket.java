package slidingwindow.fruitsbasket_904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class FruitsIntoBasket {
    
    private static int fruitsBasket(int[] inputArray)
    {
        int maxLen=0, windowStart=0;
        Map<Integer,Integer> numFreqHMap = new HashMap<Integer,Integer>();

        for(int windowEnd=0;windowEnd<inputArray.length;windowEnd++)
        {
            numFreqHMap.put(inputArray[windowEnd],numFreqHMap.getOrDefault(inputArray[windowEnd],0)+1);
            if(numFreqHMap.size()>2)
            {
                //Shrink Sliding window
                numFreqHMap.put(inputArray[windowStart], numFreqHMap.getOrDefault(inputArray[windowStart], 0)-1);
                if(numFreqHMap.get(inputArray[windowStart])==0)
                    numFreqHMap.remove(inputArray[windowStart]);
                windowStart++;
            }
            maxLen = Math.max(maxLen,windowEnd-windowStart+1);
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int maxTypesOfFruitsInBasket = fruitsBasket(inputArray);
        System.out.println(maxTypesOfFruitsInBasket);
    }
}
