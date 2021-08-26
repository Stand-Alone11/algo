package baekjoon.no16637;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, ans;
    static int[] numbers, dp;
    static char[] operators;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N / 2 + 1];
        operators = new char[N / 2];
        selected = new boolean[N / 2];
        dp = new int[N / 2];
        ans = Integer.MIN_VALUE;
        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                numbers[i / 2] = input[i] - '0';
            else
                operators[i / 2] = input[i];
        }

        for (int i = 0; i < operators.length; i++) {
            dp[i] = cal(numbers[i], operators[i], numbers[i + 1]);
        }

        for (int i = 0; i <= Math.round((double) operators.length / (double) 2); i++) {
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    static void dfs(int depth, int idx) {
        if (depth == 0) {
            getResult();
            return;
        }

        for (int i = idx; i < operators.length; i++) {
            if (!selected[i]) {
                if (i > 0) {
                    if (!selected[i - 1]) {
                        selected[i] = true;
                        dfs(depth - 1, i + 1);
                        selected[i] = false;
                    }
                } else {
                    selected[i] = true;
                    dfs(depth - 1, i + 1);
                    selected[i] = false;
                }
            }
        }
    }

    static void getResult() {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Character> q2 = new LinkedList<>();
        int idx = 0;
        while (idx < numbers.length) {
            if (idx == operators.length - 1) {
                if (selected[idx]) {
                    q1.add(cal(numbers[idx], operators[idx], numbers[++idx]));
                    break;
                } else {
                    q1.add(numbers[idx]);
                    q2.add(operators[idx]);
                    q1.add(numbers[++idx]);
                    break;
                }
            } else if (idx == numbers.length - 1) {
                q1.add(numbers[idx]);
                break;
            } else {
                if (selected[idx]) {
                    q1.add(cal(numbers[idx], operators[idx], numbers[++idx]));
                    q2.add(operators[idx]);
                    idx++;
                } else {
                    q1.add(numbers[idx]);
                    q2.add(operators[idx]);
                    idx++;
                }
            }
        }
        int result = q1.remove();
        while (!q2.isEmpty()) {
            result = cal(result, q2.remove(), q1.remove());
        }
        ans = Math.max(ans, result);
    }

    static int cal(int a, char op, int b) {
        if (op == '+')
            return a + b;
        if (op == '-')
            return a - b;
        if (op == '*')
            return a * b;
        return 0;
    }

}
