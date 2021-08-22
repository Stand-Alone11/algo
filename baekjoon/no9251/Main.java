package baekjoon.no9251;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//TODO: ans referenced
public class Main {
    static int N, M, ans;
    static char[] a1, a2;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] b1 = br.readLine().toCharArray();
        char[] b2 = br.readLine().toCharArray();
        a1 = new char[b1.length + 1];
        a2 = new char[b2.length + 1];
        N = a1.length;
        M = a2.length;

        for (int i = 0; i < N; i++) {
            if (i != 0)
                a1[i] = b1[i - 1];
        }
        for (int i = 0; i < M; i++) {
            if (i != 0)
                a2[i] = b2[i - 1];
        }
        dp = new int[N][M];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (a1[i] == a2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > ans)
                        ans = dp[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(ans);
    }

}
