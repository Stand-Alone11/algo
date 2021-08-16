package baekjoon.no2156;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] wines;
    static Integer[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        wines = new int[N + 1];
        memo = new Integer[N + 1][2];
        int maxA = Integer.MIN_VALUE;

        if (N == 1) {
            System.out.println(sc.nextInt());
            sc.close();
            return;
        }

        for (int i = 1; i <= N; i++) {
            wines[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 1; i < N; i++) {
            maxA = Math.max(maxA, dfs(i, -1));
        }
        System.out.println(maxA);
    }

    public static int dfs(int idx, int pre) {
        if (idx == N)
            return wines[idx];
        if (idx > N)
            return 0;
        if (pre + 1 != idx && memo[idx][0] != null)
            return memo[idx][0];
        else if (pre + 1 == idx && memo[idx][0] != null && memo[idx][1] != null)
            return Math.max(memo[idx][0], memo[idx][1]);
        if (pre + 1 != idx) {
            int max = 0;
            for (int i = idx + 1; i <= N; i++) {
                max = Math.max(max, dfs(i, idx));
            }
            return memo[idx][0] = wines[idx] + max;
        } else {
            int max = 0;
            for (int i = idx + 2; i <= N; i++) {
                max = Math.max(max, dfs(i, idx));
            }
            return memo[idx][1] = wines[idx] + max;
        }

    }

}
