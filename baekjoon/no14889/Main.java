package baekjoon.no14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, min;
    static int[][] map;
    static boolean[] team;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        team = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int idx, int depth) {
        if (depth == N / 2) {
            cal();
            return;
        } else {
            for (int i = idx; i < N; i++) {
                if (!team[i])
                    team[i] = true;
                dfs(i + 1, depth + 1);
                team[i] = false;
            }
        }
    }

    public static void cal() {
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (team[i] && team[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!team[i] && !team[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }

            }
        }

        int result = Math.abs(start - link);
        if (result == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, result);
    }
}
