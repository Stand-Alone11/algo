package baekjoon.no11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int counter = 1;
        while (q.size() > 1) {
            if (counter++ % K != 0)
                q.add(q.poll());
            else
                sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        System.out.println(sb.toString());
    }
}
