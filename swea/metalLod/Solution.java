package swea.metalLod;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, ans;
    static int[][] lods;
    static int[] order, dp;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/metalLod/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            lods = new int[N][2];
            v = new boolean[N];
            order = new int[N];
            int[] r = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                lods[i][0] = Integer.parseInt(st.nextToken());
                lods[i][1] = Integer.parseInt(st.nextToken());
                r[i] = -1;
            }
            for (int i = 0; i < N; i++) {
                recur(0, i, r);
            }

            for (int i = 0; i < N; i++) {
                if (order[i] == -1)
                    break;
                sb.append(lods[order[i]][0]).append(" ");
                sb.append(lods[order[i]][1]).append(" ");
            }

            System.out.println("#" + tc + " " + sb.toString().trim());
        }
    }

    static void recur(int d, int idx, int[] r) {
        if (d == N - 1) {
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
        for (int i = 0; i < N; i++) {
            if (!v[i] && lods[idx][1] == lods[i][0]) {
                recur(d + 1, i, r);
            }
        }
        v[idx] = false;
        r[d] = -1;
    }
}
