package baekjoon.no9663;

import java.util.Scanner;

public class Main {
    static boolean[][] map;
    static int N, count;
    static int[] dx = { -1, -1 };
    static int[] dy = { -1, 1 };
    static boolean[] rBA, cBA;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        count = 0;
        map = new boolean[N][N];
        rBA = new boolean[N];
        cBA = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(0, i);
        }

        System.out.println(count);
    }

    public static void dfs(int r, int c) {
        if (r == N - 1 && check(r, c)) { // N개 다 놓으면 count++
            count++;
            return;
        } else if (!check(r, c)) { // 현 위치에서 걸리면 리턴
            return;
        }

        map[r][c] = true;
        rBA[r] = true;
        cBA[c] = true;
        for (int i = 0; i < N; i++) {
            if (!rBA[r + 1] && !cBA[i]) {
                dfs(r + 1, i);
            }
        }
        rBA[r] = false;
        cBA[c] = false;
        map[r][c] = false;

    }

    public static boolean check(int r, int c) { // 벽까지 비어있으면 true, 중간에 있으면 false

        for (int i = 0; i < 2; i++) { // 윗 대각 이방탐색
            int R = r, C = c;
            while (true) {
                R += dx[i];
                C += dy[i];
                if (isWall(R, C))
                    break;
                if (map[R][C]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isWall(int r, int c) {
        if (r >= N || c >= N || r < 0 || c < 0)
            return true;
        return false;
    }
}
