package baekjoon.no2775;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            int sum = 0;
            for(int j = 0; j < a; j++) {
                for(int k = 1; k < b; k++) {
                    sum+=k;
                }
            }
            System.out.println(sum);
        }
    }
    
    void f(int a, int b) {
        
    }
}
