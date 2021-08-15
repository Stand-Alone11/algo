package baekjoon.no1463;

import java.util.Scanner;

public class Main {
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        memo = new int[N + 1];
        sc.close();

        memo[1] = 0;

        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i % 2 == 0)
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            if (i % 3 == 0)
                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
        }

        System.out.println(memo[N]);
    }
}
