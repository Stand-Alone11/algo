package baekjoon.no2565;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static int[] array, dp;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        array = new int[501];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            array[idx] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 501; i++) {
            if (array[i] != 0)
                list.add(array[i]);
        }

        lis();
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(N - max);
    }

    static void lis() {
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }
}
