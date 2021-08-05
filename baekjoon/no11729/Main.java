package baekjoon.no11729;

import java.util.ArrayList;
//TODO: not solved
import java.util.Scanner;

public class Main {
    static int count = 0;
    static int[] index = { -1, -1, -1 };
    static int[][] stks = new int[3][];
    static int N;
    static ArrayList<String> aryLst = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        stks[0] = new int[N];
        stks[1] = new int[N];
        stks[2] = new int[N];

        for (int i = 0; i < N; i++) {
            stks[0][++index[0]] = N - i;
        }

        hanoi(N, 1, 3, 2);
    }

    public static void hanoi(int n, int start, int end, int left) {
        int currentN = find(n);
        if (canMove(n, currentN, end)) { // 찾은 n의 위치에서 end로 옮길 수 있으면
            move(n, currentN, end); // n을 현위치에서 end로 옮긴다
            if (isHanoi(n, end)) {
                hanoi(n + 1, find(n + 1), left, end);
            } else {
                hanoi(n - 1, find(n - 1), end, left);
            }
        }
        hanoi(n - 1, start, left, end);
    }

    public static int find(int n) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= index[i]; j++) {
                if (stks[i][j] == n)
                    return i + 1;
            }
        }
        return -1;
    }

    public static boolean canMove(int n, int start, int end) {
        boolean a = false;

        for (int i = 0; i <= index[start - 1]; i++) { //
            if (stks[start - 1][i] == n) { // n의 인덱스를 찾고
                if (i == index[start - 1]) // 그 인덱스가 스택의 맨 위라면
                    a = true;
            }
        }

        if (index[end - 1] == -1 || stks[end - 1][index[end - 1]] < n) // 목적 스택이 비거나 맨 위가 n보다 작을 때
            return a;

        return false;
    }

    public static boolean isHanoi(int n, int end) {
        for (int i = 0; i < n; i++) {
            if (stks[end - 1][i] != n - i)
                return false; // 밑에서 부터 차례대로 n, n-1.. 이 아니면
        }
        return true;
    }

    public static void move(int n, int start, int end) {
        int a = 0;
        System.out.println(start + " " + end);

        a = stks[start - 1][index[start - 1]--];
        stks[end - 1][++index[end - 1]] = a;
    }
}
