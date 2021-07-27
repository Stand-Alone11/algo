package baekjoon.no2581;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int primeMin = 0;
        int sum = 0;

        for (int i = min; i <= max; i++) {
            int count = 0;

            for(int j = 1; j <= i; j++) {
                if(i%j == 0) count++;
            }
            if(count == 2) {
                if(primeMin == 0) primeMin = i;
                sum += i;
            }
        }

        if(primeMin == 0) {
            System.out.println(-1);
            sc.close();
            return;
        }
        System.out.println(sum);
        System.out.println(primeMin);
        sc.close();
    }
}
