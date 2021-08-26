package baekjoon.no2981;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// solving...
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for (int i = 1; i <= array[0]; i++) {

        }

    }
}
