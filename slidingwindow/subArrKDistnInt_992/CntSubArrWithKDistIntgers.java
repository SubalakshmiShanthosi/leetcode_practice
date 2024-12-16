package slidingwindow.subArrKDistnInt_992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CntSubArrWithKDistIntgers {
    
    public static int subarraysWithKDistinct(int[]nums,int k)
    {
        int n = nums.length;
        return subarraysWithKDistinctHelper(nums, n, k) - subarraysWithKDistinctHelper(nums,n, k-1);
    }

    public static int subarraysWithKDistinctHelper(int[] nums,int n , int k) {
        int count = 0; 
        Map<Integer,Integer> numCntHMap = new HashMap<>();
        int windowStart=0;
        
        for(int windowEnd=0;windowEnd<nums.length; windowEnd++)
        {
            numCntHMap.put(nums[windowEnd],numCntHMap.getOrDefault(nums[windowEnd],0)+1);
            while(numCntHMap.size()>k && windowStart < n)
            {
                numCntHMap.put(nums[windowStart], numCntHMap.getOrDefault(nums[windowStart],0)-1);
                if(numCntHMap.get(nums[windowStart])==0)
                    numCntHMap.remove(nums[windowStart]);
                windowStart++;
                

            }
            count +=(windowEnd-windowStart+1);
        }
       
        return count;

    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(bin.readLine().trim());
        int countNumArr = subarraysWithKDistinct(inputArr,k);
        System.out.println(countNumArr);
    }
}
