package baekjoon.no15652;

import java.util.Scanner;

public class Main {
    static int[] array, output;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();

        sc.close();

        array = new int[N];
        output = new int[M];

        for (int i = 0; i < N;) {
            array[i] = ++i;
        }

        dfs(0, 0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int index) {
        if (depth == M) {
            for (int i = 0; i < output.length; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < N; i++) {
            output[depth] = array[i];
            dfs(depth + 1, i);
        }
    }

}
