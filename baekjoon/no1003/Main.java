package baekjoon.no1003;

import java.util.Scanner;

public class Main {
    static int zCount, oCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            zCount = 1;
            oCount = 1;
            int a = sc.nextInt();
            if (a == 0) {
                System.out.println(1 + " " + 0);
            } else if (a == 1) {
                System.out.println(0 + " " + 1);
            } else if (a == 2) {
                System.out.println(zCount + " " + oCount);
            } else {
                for (int j = 0; j < a - 2; j++) {
                    int temp = zCount;
                    zCount = oCount;
                    oCount = temp + zCount;
                }
                System.out.println(zCount + " " + oCount);
            }

        }

        sc.close();
    }

    public static int fibo(int n) {
        if (n == 3) {
            zCount++;
            oCount += 2;
            return 0;
        } else if (n == 2) {
            oCount++;
            zCount++;
            return 1;
        } else if (n == 0) {
            zCount++;
            return 0;
        } else if (n == 1) {
            oCount++;
            return 0;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
