package baekjoon.no11053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    static Integer[] memo;
    static int N, leng;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N];
        memo = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            leng = Math.max(findNext(i), leng);
        }
        System.out.println(leng);
    }

    public static int findNext(int idx) {
        if (idx == N - 1) {
            if (memo[idx] == null)
                return memo[idx] = 1;
            return memo[idx];
        }
        if (memo[idx] != null) {
            return memo[idx];
        }

        int current = array[idx];
        int mx = 0;
        for (int i = idx + 1; i < N; i++) {
            if (current < array[i]) {
                mx = Math.max(findNext(i), mx);
            }
        }
        return memo[idx] = mx + 1;
    }
}
