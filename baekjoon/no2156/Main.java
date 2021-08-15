package baekjoon.no2156;

import java.util.Scanner;

//not solved
public class Main {
    static int N;
    static int[] wines;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        wines = new int[N];
        memo = new int[N][2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            wines[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < N; i++) {
            memo = new int[N][2];
            max = Math.max(max, dfs(i, 0));
        }
        System.out.println(max);
    }

    public static int dfs(int idx, int stp) {
        if (idx == N - 1)
            return wines[idx];
        if (idx >= N)
            return 0;
        if (stp == 0 && memo[idx][0] != 0 && memo[idx][1] != 0) { // stp 0이면 child 2개
            return Math.max(memo[idx][0], memo[idx][1]);
        } else if (stp == 1 && memo[idx][0] != 0) {
            return memo[idx][0];
        }

        int a = 0, b = 0;
        if (stp < 1)
            a = dfs(idx + 1, stp + 1);
        b = dfs(idx + 2, 0);

        if (a == 0)
            return memo[idx][0] = b + wines[idx];
        return memo[idx][1] = Math.max(a, b) + wines[idx];
    }
}
