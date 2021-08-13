package baekjoon.no1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, memo;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int N, sum;

    public static void main(String[] args) throws Exception { // 트리구조..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        memo = new int[N][3];
        visited = new boolean[N][3];

        for (int i = 0; i < N; i++) { // map setting
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            int a = recur(0, i);
            if (a < min)
                min = a;
        }
        System.out.println(min);
    }

    public static int recur(int depth, int idx) {
        if (depth == N) {
            return 0;
        }
        if (memo[depth][idx] != 0)
            return memo[depth][idx];

        int minChild = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != idx) {
                int a = recur(depth + 1, i);
                minChild = Math.min(minChild, a);
            }
        }
        return memo[depth][idx] = map[depth][idx] + minChild;
    }
}
