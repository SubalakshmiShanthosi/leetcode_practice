package patterns_printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberCrown {
    
    private static void printNumCrownPattern(int N)
    {
        int numSpacesOnFirstIter = (2*N) -1;

        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=i;j++)
                System.out.print(j);
            
            for(int j=1;j<=numSpacesOnFirstIter;j++)
                System.out.print(" ");
            for(int j=i;j>=1;j--)
                System.out.print(j);
            
            numSpacesOnFirstIter = numSpacesOnFirstIter-2;
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bin.readLine());
        printNumCrownPattern(N);
    }
}
