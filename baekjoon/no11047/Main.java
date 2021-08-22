package baekjoon.no11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ary = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (K / ary[i] > 0) {
                count += K / ary[i];
                K %= ary[i];
            }
        }

        System.out.println(count);
    }
}
