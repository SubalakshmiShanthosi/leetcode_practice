package binarysearch.nthRootOfM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NThRootOfMBinarySearch {


    private static int mTimesN(int n,int m)
    {
        return (int) Math.pow(n,m);
    }
    
    private static int nthRootOfM(int n,int m)
    {
        int low = 1;
        int high = m;
        int ans = -1;
        while(low<=high)
        {
            int mid = (high + low)/2;
            if(mTimesN(mid,n) == m)
                return mid;
            if(mTimesN(mid,n) > m)
                high = mid -1;
            else
                {
                    low = mid+1;
                }
            
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(bin.readLine().trim());
        int n = Integer.parseInt(bin.readLine().trim());
        int result = nthRootOfM(inputNum,n);
        System.out.println("n"+ n +" th Root of"+ inputNum +"is: "+result);
    }
}
