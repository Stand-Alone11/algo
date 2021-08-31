package baekjoon.no3036;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int a = 0;

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                a = sc.nextInt();
                continue;
            }
            int b = sc.nextInt();

            int gcf = getGCF(a, b);

            System.out.println(a / gcf + "/" + b / gcf);
        }
    }

    static int getGCF(int a, int b) {
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
