package baekjoon.no9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < N; j++) {
            char[] input = br.readLine().toCharArray();

            char[] stack = new char[input.length];
            int idx = -1;

            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(')
                    stack[++idx] = input[i];
                else {
                    if (idx == -1) {
                        stack[++idx] = input[i];
                    } else {
                        if (stack[idx] == '(')
                            stack[idx--] = '\u0000';
                        else
                            stack[++idx] = input[i];
                    }
                }
            }
            if (idx == -1)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}
