package baekjoon.no1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prime = 0;

        while(st.hasMoreTokens()) {
            int count = 0;
            int target = Integer.parseInt(st.nextToken());
            
            for(int i = 1; i <= target; i++) {
                if(target%i == 0) {
                    count++;
                }
            }
            if(count == 2) prime++;
        }

        System.out.println(prime);

    }
}
