package baekjoon.no1904;

import java.util.Scanner;

//TODO: ans checked
public class Main {
    static int N;
    static int[] memo;

    public static void main(String[] args) { // f(n) = f(n-1) + f(n-2)
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        if (N == 1)
            System.out.println(1);
        else if (N == 2)
            System.out.println(2);
        else {
            int a = 1;
            int b = 2;
            for (int i = 0; i < N - 2; i++) {
                int sum = (a + b) % 15746; // n 46일때 int값 벗어남..
                a = b;
                b = sum;
            }
            System.out.println(b);
        }
    }
}
