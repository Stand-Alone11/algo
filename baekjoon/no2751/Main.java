package baekjoon.no2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] array = new int[T];

        for (int i = 0; i < T; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for (int i : array) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
