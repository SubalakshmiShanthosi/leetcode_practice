package slidingwindow.slidingSubArrBeauty_2653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SlidingSubArrBeauty {
    

    public static int getKthSmallest(Map<Integer, Integer> aTreeMap, int x)
    {  
        
      int counter = 0;
      for(Integer val : aTreeMap.keySet())
      {
        if(val<0)
            counter+=aTreeMap.get(val);
        else 
            return 0; 
        
        if(counter>=x)
        {
            return val;
        }
      }
      return 0; 
    }
    public static List<Integer> getSubArrayBeauty(int[]inputArray,int k , int x)
    {
        List<Integer> resultElements = new ArrayList<Integer>();
        Map<Integer, Integer> aTreeMap = new TreeMap<Integer,Integer>();
        int windowEnd=0;
        for(int windowStart=0;windowStart<inputArray.length;windowStart++)
        {
            while(windowEnd<inputArray.length && (windowEnd-windowStart+1)<k)
            {
                if(inputArray[windowEnd]< 0)
                    aTreeMap.put(inputArray[windowEnd], aTreeMap.getOrDefault(inputArray[windowEnd],0)+1);
                windowEnd++;
            }
            if((windowEnd-windowStart+1) == k)
                resultElements.add(getKthSmallest(aTreeMap,x));

        }


        return resultElements;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = inputArray[inputArray.length-1];
        int k = inputArray[inputArray.length-2];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-2);
        System.out.println(Arrays.toString(inputArray));
        List<Integer> subArrBeautyRes = getSubArrayBeauty(inputArray,k,x);
        System.out.println(subArrBeautyRes.toString());
    }
}
