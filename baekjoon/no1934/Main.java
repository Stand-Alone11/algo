package baekjoon.no1934;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, gcf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a > b) {
                gcf = getGCF(b, a);
            } else {
                gcf = getGCF(a, b);
            }

            System.out.println(gcf * (a / gcf) * (b / gcf));

        }
    }

    static int getGCF(int sm, int bg) {
        int cf = 1;
        for (int i = sm; i > 0; i--) {
            if (sm % i == 0) {
                if (bg % i == 0)
                    return gcf = i;
            }
        }
        return cf;
    }
}
