package baekjoon.no13305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] route = new long[N - 1];
        long min = Integer.MAX_VALUE;
        long ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) { // route 저장
            route[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            long a = Long.parseLong(st.nextToken());
            if (min > a) {
                min = a;
            }
            ans += min * route[i];
        }

        System.out.println(ans);
    }
}
