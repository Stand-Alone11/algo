package baekjoon.no2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) { // card setting
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int a, b, c;
        a = b = c = 0;

        for (int i = 0; i <= N - 3; i++) {
            a = cards[i];
            for (int j = i + 1; j <= N - 2; j++) {
                b = cards[j];
                for (int k = j + 1; k <= N - 1; k++) {
                    c = cards[k];
                    if (ans < a + b + c && a + b + c <= M)
                        ans = a + b + c;
                }
            }
        }

        System.out.println(ans);

    }
}
