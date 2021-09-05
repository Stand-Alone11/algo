package baekjoon.no1021;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Deque<Integer> d = new LinkedList<>();
    static int counter = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] o = new int[M];
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            d.add(i);
        }

        for (int i = 0; i < M; i++) {
            o[i] = sc.nextInt();
        }

        while (idx != M) {
            int a = o[idx];
            int dI = 0;
            for (Integer i : d) {
                if (i == a) {
                    break;
                }
                dI++;
            }
            if (dI <= d.size() / 2) {
                for (int i = 0; i < dI; i++) {
                    left();
                }
                d.poll();
            } else {
                for (int i = 0; i < d.size() - dI; i++) {
                    right();
                }
                d.poll();
            }
            idx++;
        }
        sc.close();

        System.out.println(counter);
    }

    static void left() {
        counter++;
        d.add(d.poll());
    }

    static void right() {
        counter++;
        d.addFirst(d.pollLast());
    }
}
