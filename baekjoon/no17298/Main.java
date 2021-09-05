package baekjoon.no17298;

import java.util.Scanner;
import java.util.Stack;

//TODO: ans referenced 어떻게 생각해냄???
public class Main {
    static int N;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        N = sc.nextInt();
        input = new int[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
                input[stack.pop()] = input[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            input[stack.pop()] = -1;
        }

        for (int ele : input) {
            sb.append(ele).append(" ");
        }
        System.out.println(sb.toString());
    }
}
