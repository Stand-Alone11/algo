package baekjoon.no2579;

import java.util.Scanner;

public class Main {
    static int N, max;
    static int[] step;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        step = new int[N + 1];
        memo = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            step[i] = sc.nextInt();
        }
        sc.close();
        int ans = dfs(0, 0, -1);
        System.out.println(ans);
    }

    public static int dfs(int current, int stp, int stpC) {
        if (current == N)
            return step[N];
        if (current > N)
            return 0;
        if (stpC != -1 && memo[current][stpC] != 0)
            return memo[current][stpC];
        int a = 0, b = 0;
        if (stpC < 1) {
            a = dfs(current + 1, 1, stpC + 1);
        }
        b = dfs(current + 2, 2, 0);
        if (a == 0 && b == 0)
            return 0;
        if (stpC == 1)
            return memo[current][1] = Math.max(a, b) + step[current];
        return memo[current][0] = Math.max(a, b) + step[current];
    }
}
