package baekjoon.no4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            char[] array = input.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < array.length; i++) {
                if (stack.isEmpty()) {
                    if (array[i] == '(' || array[i] == ')' || array[i] == '[' || array[i] == ']')
                        stack.add(array[i]);
                } else {
                    if (array[i] == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.add(array[i]);
                        }
                    } else if (array[i] == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.add(array[i]);
                        }
                    } else if (array[i] == '(' || array[i] == '[') {
                        stack.add(array[i]);
                    }
                }
            }
            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
