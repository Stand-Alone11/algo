package baekjoon.no17298;

import java.util.Scanner;

//TODO: solving..
public class Main {
    static int N;
    static int[] input;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();

        int start = 0, end = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (input[i] < input[j]) {
                    start = i;
                    end = j;
                    break;
                }
                if (input[j] < input[start]) {
                }

            }
        }

    }

}
