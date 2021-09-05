package swea.findMatrix;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/findMatrix/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringBuilder sb = new StringBuilder();
            ArrayList<int[]> dp = new ArrayList<>(); // [i][0]: x [i][1]: y

            for (int i = 0; i < N; i++) { // map setting
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) {
                        dp.add(findMatrix(i, j));
                    }
                }
            }

            sb.append(dp.size()).append(" ");
            Collections.sort(dp, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    int size1 = o1[0] * o1[1];
                    int size2 = o2[0] * o2[1];
                    if (size1 == size2) {
                        return Integer.compare(o1[0], o2[0]);
                    }
                    return Integer.compare(size1, size2);
                }

            });
            for (int i = 0; i < dp.size(); i++) {
                sb.append(dp.get(i)[0]).append(" ");
                sb.append(dp.get(i)[1]).append(" ");
            }

            System.out.println("#" + tc + " " + sb.toString().trim());

        }
    }

    static int[] findMatrix(int x, int y) {
        int r = x;
        int c = y;
        while (isWall(x, ++c) | map[x][c] != 0) {

        }
        while (isWall(++r, y) | map[r][y] != 0) {

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
