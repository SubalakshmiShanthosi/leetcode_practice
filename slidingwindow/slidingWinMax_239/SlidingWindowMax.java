package slidingwindow.slidingWinMax_239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {

    private static int[] maxSlidingWindow(int[]nums,int k)
    {
        int[] resultList = new int[nums.length-k+1];
        int windowStart=0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++)
        {
            while(!queue.isEmpty() && queue.peekLast() < nums[windowEnd])
            {
                
                queue.removeLast();
            }

            queue.add(nums[windowEnd]);

            //Check if the window size K is maintained

            if(windowEnd >= k-1)
            {
                resultList[windowStart]=queue.peekFirst();

                if(queue.peekFirst()== nums[windowStart]){
                    queue.removeFirst();
                }
                windowStart++;
            }

        }
        return resultList;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = inputArray[inputArray.length-1];
        inputArray = Arrays.copyOf(inputArray, inputArray.length-1);
        int[]resultMaxEle = maxSlidingWindow(inputArray,k);
        System.out.println(Arrays.toString(resultMaxEle));

    }
}
