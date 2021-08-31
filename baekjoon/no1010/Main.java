package baekjoon.no1010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long numer = 1;
            for (int j = 0; j < a; j++) {
                numer = numer * (b - j);
                numer = numer / (j + 1);
            }
            sb.append(String.valueOf(numer)).append("\n");
        }
        System.out.println(sb.toString());
    }
}