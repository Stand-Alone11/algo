package baekjoon.no1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        lis();
        System.out.println(max);
    }

    public static void lis() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            max = Math.max(max, sum);
        }

    }
}
