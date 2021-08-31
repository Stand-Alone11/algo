package baekjoon.no2981;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//TODO: solving.. ans referenced
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i < array[1] + 1; i++) {
            int result = array[0] % i;
            for (int j = 0; j < array.length; j++) {
                if (j == array.length - 1 && array[j] % i == result)
                    sb.append(i).append(" ");
                if (array[j] % i != result)
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
