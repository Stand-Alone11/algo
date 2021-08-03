package baekjoon.no1018;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO: not solved 체스판 2가지 모두 비교 후 최솟값 찾기
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] grid = new char[N][M];
        char[][] chessW = new char[8][8];
        char[][] chessB = new char[8][8];

        for (int i = 0; i < N; i++) { // grid setting
            String str = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < M; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

    }
}
