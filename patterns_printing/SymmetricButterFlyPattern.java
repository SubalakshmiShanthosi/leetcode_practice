package patterns_printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricButterFlyPattern {

    private static void printSymmButterFlyPatt(int N)
    {
        int spaceInitial = 2 * N-2;

        for(int i=1;i<=((2*N)-1);i++)
        {
            int stars = i;
            if(i>N) 
                stars = 2*N - i;

            for(int j=1;j<=stars;j++)
                System.out.print("*");
            
            for(int j=1;j<=spaceInitial;j++)
                System.out.print(" ");
            
            //for printing the stars
          for(int j = 1;j<=stars;j++)
            System.out.print("*");
       
            System.out.println();
            if(i<N) spaceInitial -=2;
            else spaceInitial +=2;

            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bin.readLine());
        printSymmButterFlyPatt(n);
    }
}
