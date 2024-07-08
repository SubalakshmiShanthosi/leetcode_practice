package slidingwindow.startEndIndOfSumK_GFG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrIndOfSumK {
    
    private static ArrayList<Integer> subArraySum(int[] inputArray, int K)
    {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        int windowStart=0;
        int windowSum=0;
        int last=0;
        boolean flag=false;
        for(int windowEnd=0;windowEnd<inputArray.length;windowEnd++)
        {
            windowSum+=inputArray[windowEnd];
            
            if(windowSum>=K){
                last = windowEnd;
                while (K < windowSum && windowStart < last) {
                    windowSum -=inputArray[windowStart];
                    windowStart++;
            }
        }
            if(windowSum==K)
            {
                resultList.add(windowStart+1);
                resultList.add(windowEnd+1);
                flag = true;
                break;
            }
            
        }

        if (!flag)
            resultList.add(-1);
        
        return resultList;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArray = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int K = inputArray[inputArray.length-1];
        inputArray = Arrays.copyOf(inputArray,inputArray.length-1);
        ArrayList<Integer> resultIndices = subArraySum(inputArray,K);
        System.out.println(resultIndices.toString());
    }
}
