package baekjoon.no2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

//TODO: ans referenced not solved
public class Main {
    static int[][] map = new int[9][9];
    static ArrayList<int[]> zCoord = new ArrayList<>();
    static int idx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int a = map[i][j] = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    int[] b = { i, j };
                    zCoord.add(b);
                }
            }
        }

        while (zCoord.size() > 0) {

            int r = zCoord.get(idx)[0];
            int c = zCoord.get(idx)[1];

            if (searchRow(r, c) && searchColumb(r, c) && searchSqr(r, c)) {
                idx++;
            }

        }
    }

    static boolean searchRow(int r, int c) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (map[r][i] != 0) {
                check[i] = true;
            }
        }
        int count = 0;
        int val = -1;
        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                count++;
                val = i + 1;
            }
        }
        if (count == 1) {
            map[r][c] = val;
            return false;
        } else {
            return true;
        }

    }

    static boolean searchColumb(int r, int c) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (map[i][c] != 0) {
                check[i] = true;
            }
        }
        int count = 0;
        int val = -1;
        for (int i = 0; i < 9; i++) {
            if (!check[i]) {
                count++;
                val = i + 1;
            }
        }
        if (count == 1) {
            map[r][c] = val;
            return false;
        } else {
            return true;
        }

    }

    static boolean searchSqr(int r, int c) {
        if (r < 3) {
            if (c < 3) {

            } else if (c < 6) {

            } else {

            }
        } else if (r < 6) {
            if (c < 3) {

            } else if (c < 6) {

            } else {

            }
        } else {
            if (c < 3) {

            } else if (c < 6) {

            } else {

            }
        }
    }

}
