package baekjoon.no4948;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0;
        while(input != 0) {
            int a = input;
            int b = 2*a;
            boolean[] primes = new boolean[b+1];

            for(int i = 2; i <= b; i++) {
                if(primes[i]) continue;

                if(i > a) {
                    count++;
                }

                for(int j = 2*i; j <= b; j += i) {
                    primes[j] = true;
                }
            }

            System.out.println(count);
            input = sc.nextInt();
            count = 0;
        }
        sc.close();
        
    }
}
