package baekjoon.no2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        double mean = 0.0, sum = 0.0;
        int[] input = new int[N];
        int[] count = new int[8001];
        int[] output = new int[N];

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            input[i] = a;
            count[a + 4000]++;
            if (max <= a)
                max = a;
            if (min >= a)
                min = a;
            sum += a;
        }

        int freqMax = getMax(count) - 4000;

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            output[--count[input[i] + 4000]] = input[i];
        }

        sb.append(Math.round(sum / N)).append("\n");
        sb.append(output[N / 2]).append("\n");
        sb.append(freqMax).append("\n");
        sb.append(max - min);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int getMax(int[] array) {
        int a = Integer.MIN_VALUE;
        int counter = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (a < array[i]) {
                a = array[i];
                index = i;
                counter = 0;
            } else if (a == array[i] && counter < 1) {
                counter++;
                index = i;
            }
        }

        return index;
    }
}
