package baekjoon.no11729;

import java.util.ArrayList;
//TODO: not solved
import java.util.Scanner;

public class Main {
    static int count = 0;
    static int i1 = -1;
    static int i2 = -1;
    static int i3 = -1;
    static int[] stk1, stk2, stk3;
    static ArrayList<String> aryLst = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        stk1 = new int[N];
        stk2 = new int[N];
        stk3 = new int[N];

        for (int i = 0; i < N; i++) {
            stk1[++i1] = N - i;
        }

        hanoi(N, 1, 3, 2);
    }

    public static void hanoi(int n, int start, int end, int left) {
        if (canMove(n, start, end)) {
            move(n, start, end, left);
            hanoi(n + 1, start, left, end);
        }
        hanoi(n - 1, start, left, end);
    }

    public static boolean canMove(int n, int start, int end) {
        boolean a = false;

        switch (start) {
            case 1:
                if (stk1[i1] == n) {
                    a = true;
                }
                break;
            case 2:
                if (stk2[i2] == n) {
                    a = true;
                }
                break;
            case 3:
                if (stk3[i3] == n) {
                    a = true;
                }
                break;
        }
        switch (end) {
            case 1:
                if (i1 == -1 || stk1[i1] < n)
                    return a;
                break;
            case 2:
                if (i2 == -1 || stk2[i2] < n)
                    return a;
                break;
            case 3:
                if (i3 == -1 || stk3[i3] < n)
                    return a;
                break;
        }
        return false;
    }

    public static void move(int n, int start, int end, int left) {
        int a = 0;
        System.out.println(start + " " + end);
        switch (start) {
            case 1:
                a = stk1[i1--];
                break;
            case 2:
                a = stk2[i2--];
                break;
            case 3:
                a = stk3[i3--];
                break;
        }
        switch (end) {
            case 1:
                stk1[++i1] = a;
                break;
            case 2:
                stk2[++i2] = a;
                break;
            case 3:
                stk3[++i3] = a;
                break;
        }
    }
}
