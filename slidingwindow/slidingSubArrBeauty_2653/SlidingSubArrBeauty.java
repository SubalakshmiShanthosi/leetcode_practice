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
    

   //returns the xth smallest num or 0 otherwise
   private static int getXthSmallestNum(TreeMap<Integer, Integer> map, int x){
    int runningCount = 0;
    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        int key = entry.getKey();
        int val = entry.getValue();

        //consider only if the key is less than 0
        if(key < 0){
            //increment the count by the number of keys present
            runningCount += val;
        }
        //check at any point we found out the xth smallest num
        //then return it
        if(runningCount >= x)
            return key;
    }

    //return the default as 0 if we don't find the xth element.
    return 0;
}

    public static int[] getSubArrayBeauty(int[]inputArray,int k , int x)
    {
         //store the nums in a sorted map or call freq map
         Map<Integer,Integer> map = new TreeMap<Integer, Integer>();//Num vs Num Count...Default is asc sorted
         //iterate over the nums array
         int n = inputArray.length, resultIdx = 0;
         int[] result = new int[n - k + 1];
         for(int i = 0; i < n; i++){
             //first thing to store in the map
             map.put(inputArray[i], map.getOrDefault(inputArray[i], 0) + 1);
             //remove older entries
             int outOfWindow = i - k < 0 ? Integer.MAX_VALUE : inputArray[i - k];
             map.put(outOfWindow, map.getOrDefault(outOfWindow, 0) - 1);
             if(i >= k-1){
                 //since by now we should only have nums in the curr window
                 //we can ask the helper to fetch the xth element or 0 otherwise
                 result[resultIdx++] = getXthSmallestNum((TreeMap<Integer, Integer>) map, x);
             }
         }
         return result;    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = inputArray[inputArray.length-1];
        int k = inputArray[inputArray.length-2];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-2);
        int[] subArrBeautyRes = getSubArrayBeauty(inputArray,k,x);
        System.out.println(Arrays.toString(subArrBeautyRes));
    }
}
