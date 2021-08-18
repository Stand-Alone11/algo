package baekjoon.no1110;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = n;
        int count = 0;
        while (true) {
            count++;
            int a = d / 10;
            int b = d % 10;
            int c = a + b;
            if (c < 10) {
                d = b * 10 + c;
            } else {
                d = b * 10 + c % 10;
            }
            if (d == n)
                break;
        }
        sc.close();
        System.out.println(count);
    }
}
