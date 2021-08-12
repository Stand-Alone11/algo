package baekjoon.no9461;

import java.util.Scanner;

public class Main {
    static long[] m = new long[101];

    public static void main(String[] args) { // f(n) = f(n-2) + f(n-3)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            // System.out.println(recur(sc.nextInt()));
            int in = sc.nextInt();
            if (in == 1 || in == 2 || in == 3) {
                System.out.println(1);
            } else {
                long sum = 0;
                long a = 1;
                long b = 1;
                long c = 1;
                for (int j = 0; j < in - 3; j++) {
                    sum = a + b;
                    a = b;
                    b = c;
                    c = sum;
                }
                System.out.println(sum);
            }
        }

        sc.close();
    }
}
