package slidingwindow.housing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HousingSlidingWinSum {
    
   
    public static void housing(int[] vacantLots, int K)
    {
        int windowStart=0;
        int windowEnd=0;
        int windowSum=0;
        while(windowEnd<vacantLots.length)
        {
            windowSum+=vacantLots[windowEnd];
            windowEnd++;
            
            while(windowSum > K && windowStart < windowEnd)
            {
                windowSum = windowSum - vacantLots[windowStart];
                windowStart++;
            }
            if(windowSum == K)
            {
                 System.out.println("["+ windowStart +","+ (windowEnd-1) + "]");

            }
        }

    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] vacantLots = Arrays.stream(in.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int K = vacantLots[vacantLots.length-1];
        vacantLots = Arrays.copyOf(vacantLots,vacantLots.length-1);
        housing(vacantLots,K);
    }
}