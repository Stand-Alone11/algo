package baekjoon.no1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            if (idx <= a) {
                for (int j = idx + 1; j <= a; j++) {
                    stack.push(j);
                    idx++;
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else if (!stack.isEmpty() & stack.peek() == a) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println(sb.toString());
    }
}
