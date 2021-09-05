package swea.chemical;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N, ans;
    static int[][] map;
    static ArrayList<int[]> mat;
    static int[] order, orderOfO;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/chemical/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            mat = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) {
                        mat.add(findMatrix(i, j));
                    }
                }
            }

            int[] r = new int[mat.size()];
            v = new boolean[mat.size()];

            for (int i = 0; i < mat.size(); i++) {
                recur(0, i, r);
            }

            int sum = 0;
            int f = mat.get(order[0])[0];
            orderOfO = new int[mat.size()];

            // dp..
            // for (int i = 0; i < mat.size() - 1; i++) {
            // int[] m = mat.get(order[i]);
            // int[] m1 = mat.get(order[i + 1]);
            // sum += (f * m[1]) * m1[1];
            // }

            System.out.println("#" + tc + " " + sum);

        }
    }

    static void recur(int d, int idx, int[] r) {
        if (d == mat.size() - 1) {
            r[d] = idx;
            order = r.clone();
            ans = d + 1;
            return;
        }
        v[idx] = true;
        r[d] = idx;
        if (d + 1 > ans) {
            order = r.clone();
            ans = d + 1;
        }
        for (int i = 0; i < mat.size(); i++) {
            if (!v[i] && mat.get(idx)[1] == mat.get(i)[0]) {
                recur(d + 1, i, r);
            }
        }
        v[idx] = false;
        r[d] = -1;
    }

    static int[] findMatrix(int x, int y) {
        int r = x;
        int c = y;
        while (!isWall(x, ++c)) {
            if (map[x][c] == 0)
                break;
        }
        while (!isWall(++r, y)) {
            if (map[r][y] == 0)
                break;
        }
        for (int i = x; i < r; i++) {
            for (int j = y; j < c; j++) {
                map[i][j] = 0;
            }
        }
        int[] a = { r - x, c - y };
        return a;
    }

    static boolean isWall(int x, int y) {
        return !(x >= 0 && x < N && y >= 0 && y < N);
    }
}
