//package baekjoon.no2775;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine()); // testcase

        for(int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] ap = new int[k+1][n+1];

            for (int j = 1; j < n + 1; j++) {
                ap[0][j] = j;
            }

            for (int l = 1; l < k + 1; l++) {
                int sum = 0;
                for(int m = 1; m < n+1; m++) {
                    sum += ap[l-1][m];
                    ap[l][m] = sum;
                }
                
            }

            System.out.println(ap[k][n]);
        }
    }
    
}
