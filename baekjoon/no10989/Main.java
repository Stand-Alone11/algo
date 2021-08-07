package baekjoon.no10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] array = new int[T];
        int[] output = new int[T];
        int[] counts = new int[10001];

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            array[i] = input;
            counts[input]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = T - 1; i >= 0; i--) {
            output[--counts[array[i]]] = array[i];
        }

        for (int i = 0; i < T; i++) {
            sb.append(output[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
