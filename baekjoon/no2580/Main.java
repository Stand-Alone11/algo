package baekjoon.no2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

//TODO: not solved
public class Main {
    static int[][] map = new int[9][9];
    static int[] counters = new int[9];
    static ArrayList<Coord> aList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.go();
    }

    public void go() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int counter = 0;
            for (int j = 0; j < 9; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if (v == 0)
                    aList.add(new Coord(i, j));
            }
            counters[i] = counter;
        }

        solve();
    }

    public static void solve() {
        for (int i = 0; i < 9; i++) {
            if (counters[i] == 1) { // i는 0의 r
                findBlank(i);
                counters[i]--;
            }
        }
    }

    public static void findBlank(int r) {
        boolean[] b = new boolean[10];
        int c = -1;
        for (Coord co : aList) {
            if (co.r == r) {
                c = co.c;
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            b[map[r][i]] = true;
        }
        for (int i = 1; i <= 9; i++) {
            if (!b[i]) {
                map[r][c] = i;
                break;
            }
        }
    }

    class Coord {
        public int r, c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
