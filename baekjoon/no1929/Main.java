package baekjoon.no1929;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] primes = new boolean[b + 1];       
        
        for(int i = 2; i <= b; i++) {
            if(primes[i]) continue;

            if(i >= a) {
                sb.append(i).append('\n');
            }

            for(int j = i + i; j <= b; j+=i) {
                primes[j] = true;
            }
        }
        System.out.println(sb);
        
    }
}
