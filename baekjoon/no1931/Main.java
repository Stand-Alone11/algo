package baekjoon.no1931;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//TODO: ans referenced
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];
        int start = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(temp[0]);
            array[i][1] = Integer.parseInt(temp[1]);
        }

        Arrays.sort(array, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }

        });

        for (int i = 0; i < N; i++) {
            if (start <= array[i][0]) {// start가 min 크거나 같다면
                start = array[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
