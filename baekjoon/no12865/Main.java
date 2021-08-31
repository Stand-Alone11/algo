package baekjoon.no12865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO: ans referenced
public class Main {
    static int N, K;
    static int[] W, V;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new Integer[N][K + 1];
        W = new int[N];
        V = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N - 1, K));
    }

    static int knapsack(int idx, int k) {
        if (idx < 0)
            return 0;

        if (dp[idx][k] == null) {
            if (W[idx] > k) {
                dp[idx][k] = knapsack(idx - 1, k);
            } else {
                dp[idx][k] = Math.max(knapsack(idx - 1, k), knapsack(idx - 1, k - W[idx]) + V[idx]);
            }
        }
        return dp[idx][k];
    }

}
