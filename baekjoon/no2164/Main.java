package baekjoon.no2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        for (int i = 0; i < N;) {
            q.add(++i);
        }

        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }
}
