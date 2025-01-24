package binarysearch.kokoEatingBananas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KokoEatingBananas {
    

    private static int calcTotalHrs(int[] piles, int currSpeed)
    {
        int sum = Arrays.stream(piles).map(n ->  (int) Math.ceil((double) n / currSpeed)).sum();
        return sum;

    }
    private static int minEatingSpeed(int[] piles, int hrs)
    {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = Integer.MAX_VALUE;

        while (low<=high) {
            int middle = (high+low)/2;
            int totalHrs = calcTotalHrs(piles,middle);
            if(totalHrs<=hrs)
            {
                high = middle-1;
            }
            else
            {
                low= middle+1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int[] piles = Arrays.stream(bin.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int hrs = Integer.parseInt(bin.readLine().trim());
        int minEatingSpeed = minEatingSpeed(piles,hrs);
        System.out.println(minEatingSpeed);
    }
}
