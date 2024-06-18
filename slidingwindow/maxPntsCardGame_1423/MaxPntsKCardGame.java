package slidingwindow.maxPntsCardGame_1423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxPntsKCardGame {
    
    public static int getMaxScoreContArr(int[]inputArray, int k)
    {
        int result = Integer.MIN_VALUE;
        

        int leftSum = 0;
        
        for(int i=0;i<k;i++)
            leftSum+=inputArray[i];
        
        int rightSum=0;
        int rightIndex = inputArray.length;
        
        result = leftSum;

        for (int leftIndex = k - 1; leftIndex >= 0;
             leftIndex--) { // pointer for the left cards
            leftSum -= inputArray[leftIndex]; // transition between choices
            rightIndex--;
            rightSum += inputArray[rightIndex];
            //System.out.println("Leftsum:"+leftSum+" leftIndex:"+leftIndex+" right sum:"+rightSum+"rightIndex: "+rightIndex);
            result = Math.max(result, leftSum + rightSum);
        }

        return result; 
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inpArr = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = inpArr[inpArr.length-1];
        inpArr = Arrays.copyOf(inpArr, inpArr.length-1);
        int maxScoreArr = getMaxScoreContArr(inpArr,k);
        System.out.println(maxScoreArr);
    }
}
