package two_pointers.twoSum_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    


    private static int[] twoSum(int[] nums, int target)
    {   
        Map<Integer,Integer> twoSumIndHMap = new HashMap<>();
        int[] resultIndices = new int[2];
         for(int index=0;index<nums.length;index++)
         {
            int temp = target-nums[index];
            if(!twoSumIndHMap.containsKey(temp))
            {
                twoSumIndHMap.put(nums[index], index);
            }
            else{
                resultIndices[0] = twoSumIndHMap.getOrDefault(temp, 0);
                resultIndices[1]= index;
            }

         }
         return resultIndices;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(bin.readLine().trim());
        int[] twoSumRes = twoSum(inputArray,target);
        System.out.println(Arrays.toString(twoSumRes));
    }
}
