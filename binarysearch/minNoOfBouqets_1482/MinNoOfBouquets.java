package binarysearch.minNoOfBouqets_1482;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinNoOfBouquets {
    

    private static boolean checkCanMakeBouquets(int[] bloomDays,int m, int k, int currDay)
    {
        int noOfBouquets=0;
        int flowersInBouquets=0;
        for(int day: bloomDays)
        {
            if(day<=currDay)
            {
                flowersInBouquets++;
                if(flowersInBouquets == k)
                {
                    noOfBouquets+=1;
                    flowersInBouquets=0;
                }
                else
                    flowersInBouquets=0;
            }
        }
        return noOfBouquets >=m;
    }

    private static int minDays(int[] bloomDays,int m,int k)
    {
        if((long) m * k > bloomDays.length)
            return -1;
        int low = Arrays.stream(bloomDays).min().getAsInt();
        int high = Arrays.stream(bloomDays).max().getAsInt();

        while(low< high)
        {
            int middle = (low+high) >>> 1;
            if(checkCanMakeBouquets(bloomDays,m,k,middle))
                high = middle;
            else
                low = middle+1;
        }
        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] bloomDays = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(bin.readLine().trim());
        int k = Integer.parseInt(bin.readLine().trim());
        int minDays = minDays(bloomDays,m,k);
        System.out.println(minDays);
    }
}
