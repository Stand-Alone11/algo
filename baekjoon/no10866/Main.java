package baekjoon.no10866;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N * 2 + 1];
        int nose = N;
        int tail = N;

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            switch (temp[0]) {
                case "push_front":
                    d[nose--] = Integer.parseInt(temp[1]);
                    break;
                case "push_back":
                    d[++tail] = Integer.parseInt(temp[1]);
                    break;
                case "pop_front":
                    if (nose == tail) {
                        ap(-1);
                    } else {
                        ap(d[++nose]);
                    }
                    break;
                case "pop_back":
                    if (nose == tail) {
                        ap(-1);
                    } else {
                        ap(d[tail--]);
                    }
                    break;
                case "size":
                    ap(tail - nose);
                    break;
                case "empty":
                    if (tail == nose) {
                        ap(1);
                    } else {
                        ap(0);
                    }
                    break;
                case "front":
                    if (tail == nose) {
                        ap(-1);
                    } else {
                        ap(d[nose + 1]);
                    }
                    break;
                case "back":
                    if (tail == nose) {
                        ap(-1);
                    } else {
                        ap(d[tail]);
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    public static void ap(int i) {
        sb.append(i).append("\n");
    }
}
