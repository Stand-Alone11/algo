package baekjoon.no10773;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stack = new int[n];
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a == 0) {
                stack[idx--] = 0;
            } else {
                stack[++idx] = a;
            }
        }

        int sum = 0;
        for (int i = 0; i <= idx; i++) {
            sum += stack[i];
        }
        System.out.println(sum);
        sc.close();
    }
}
