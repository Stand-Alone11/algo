package baekjoon.no18258;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        sb = new StringBuilder();
        int a = -1;
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            switch (temp[0]) {
                case "push":
                    a = Integer.parseInt(temp[1]);
                    q.add(a);
                    break;
                case "front":
                    if (q.isEmpty()) {
                        ap(-1);
                    } else {
                        ap(q.peek());
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        ap(-1);
                    } else {
                        ap(a);
                    }
                    break;
                case "size":
                    if (q.isEmpty()) {
                        ap(0);
                    } else {
                        ap(q.size());
                    }
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        ap(-1);
                    } else {
                        ap(q.poll());
                    }
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        ap(1);
                    } else {
                        ap(0);
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    static void ap(int a) {
        sb.append(a).append("\n");
    }
}
