package baekjoon.no1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min1 = 0;
        int min2 = 0;
        int ans = Integer.MAX_VALUE;
        char[][] grid = new char[N][M];
        char[][] chessW = new char[8][8];
        char[][] chessB = new char[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 0) {
                    if (i % 2 == 0) {
                        chessW[i][j] = 'W';
                        chessB[i][j] = 'B';
                    } else {
                        chessW[i][j] = 'B';
                        chessB[i][j] = 'W';
                    }
                } else {
                    if (i % 2 == 0) {
                        chessW[i][j] = 'B';
                        chessB[i][j] = 'W';
                    } else {
                        chessW[i][j] = 'W';
                        chessB[i][j] = 'B';
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) { // grid setting
            String str = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min1 = 0;
                min2 = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (grid[i + k][j + l] != chessB[k][l]) {
                            min1++;
                        }
                        if (grid[i + k][j + l] != chessW[k][l]) {
                            min2++;
                        }
                    }
                }
                ans = Math.min(ans, Math.min(min1, min2));
            }
        }

        System.out.println(ans);
    }
}
