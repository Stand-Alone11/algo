package baekjoon.no10844;

import java.util.Scanner;

//TODO: ans referenced
public class Main {
    static int N;
    static long sum;
    static long[][] memo;
    static long d = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new long[N + 1][10];
        sc.close();

        for (int i = 1; i < 10; i++)
            sum += dfs(N, i);

        System.out.println(sum % d);
    }

    public static long dfs(int depth, int n) {
        if (depth == 1)
            return memo[depth][n] = 1;
        if (memo[depth][n] != 0)
            return memo[depth][n];
        if (n == 9)
            memo[depth][n] = dfs(depth - 1, n - 1);
        else if (n == 0)
            memo[depth][n] = dfs(depth - 1, n + 1);
        else {
            long a = dfs(depth - 1, n - 1);
            long b = dfs(depth - 1, n + 1);
            memo[depth][n] = a + b;
        }
        return memo[depth][n] % d;
    }
}
