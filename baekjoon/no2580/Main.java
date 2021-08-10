package baekjoon.no2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static int[] counters = new int[9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int counter = 0;
            for (int j = 0; j < 9; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if (v == 0)
                    counter++;
            }
            counters[i] = counter;
        }

        solve();
    }

    public static void solve() {
        for (int i = 0; i < 9; i++) {
            if (counters[i] == 1) {
                for (int j = 0; j < 9; j++) {

                }
            }
        }
    }

}
