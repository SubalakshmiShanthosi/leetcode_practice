package slidingwindow.minOpstomakearrCont_2009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinOpsToMakeArrCont {
    public static int minOperations(int[] nums) {
        int minOps = nums.length;
       
        int windowStart = 0; 
        Set<Integer> uniqueEleSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Integer[] newArr = uniqueEleSet.toArray(new Integer[0]);

        Arrays.sort(newArr);
        for(int windowEnd=0;windowEnd<newArr.length;windowEnd++)
        {
            while (windowStart < newArr.length && newArr[windowStart]< newArr[windowEnd]+nums.length) {
                windowStart++;
            }
            minOps = Math.min(minOps,nums.length - (windowStart-windowEnd));
        }
        return minOps;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numMinOps = minOperations(inputArr);
        System.out.println(numMinOps);
    }
}
