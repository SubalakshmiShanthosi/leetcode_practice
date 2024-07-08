package patterns_printing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphaHill {

    private static void printAlphaHill(int N)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N-i-1;j++)
                System.out.print(" ");
            
            int breakpoint = ((2*i)+1)/2;
            char ch='A';
            for(int j=1;j<=(2*i+1);j++)
            {
                System.out.print(ch);
                if(j<=breakpoint)
                    ch++;
                else 
                    ch--;

            }
            for(int j=0;j<N-i-1;j++)
                System.out.print(" ");
        System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bin.readLine());
        printAlphaHill(N);
    }
}
