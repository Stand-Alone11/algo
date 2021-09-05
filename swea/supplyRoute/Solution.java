package swea.supplyRoute;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    static int N, min;
    static int[][] map, ans;
    static boolean[][] visited;
    static PriorityQueue<Info> qu;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/supplyRoute/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;

            map = new int[N][N];
            ans = new int[N][N];
            visited = new boolean[N][N];
            qu = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                Arrays.fill(ans[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bfs(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    static void bfs(int a, int b) {
        visited[a][b] = true;
        qu.add(new Info(a, b, 0));

        while (!qu.isEmpty()) {
            Info info = qu.poll();

            int x = info.x;
            int y = info.y;
            int time = info.time;

            if (x == N - 1 && y == N - 1) {
                if (min > time)
                    min = time;
            }

            if (min <= time)
                continue;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (!isWall(newX, newY)) {
                    int eTime = time + map[newX][newY];
                    if (!visited[newX][newY] || eTime < ans[newX][newY]) {
                        visited[newX][newY] = true;
                        ans[newX][newY] = eTime;
                        qu.add(new Info(newX, newY, eTime));
                    }
                }
            }

        }
    }

    static class Info implements Comparable<Info> {
        public int x, y, time;

        public Info(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.time, o.time);
        }

    }

    static boolean isWall(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return true;
        return false;
    }

}
