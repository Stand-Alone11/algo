package baekjoon.no1932;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] memo, map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        memo = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = Math.max(map[i][j], map[i][j + 1]);
                map[i - 1][j] = map[i - 1][j] + a;
            }
        }
        System.out.println(map[0][0]);
    }
}
