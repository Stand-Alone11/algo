package baekjoon.no11650;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(temp[0]);
            map[i][1] = Integer.parseInt(temp[1]);
        }

        quick(map, 0, N - 1, 0);

        int start = 0;
        int end = 0;
        for (int i = 1; i < N - 1; i++) {
            if (map[i - 1][0] < map[i][0]) {
                quick(map, start, end, 1);
                start = i;
                end = i;
            } else if (map[i - 1][0] == map[i][0]) {
                end = i;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map[i][0]).append(" ").append(map[i][1]).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void quick(int[][] array, int l, int r, int mode) {
        if (l >= r)
            return;
        int piv = partition(array, l, r, mode);

        quick(array, l, piv - 1, mode);
        quick(array, piv + 1, r, mode);
    }

    public static int partition(int[][] array, int l, int r, int mode) {
        int mid = (r + l) / 2;
        swap(array, l, mid);

        int piv = array[l][mode];
        int[] pivA = array[l];

        int i = l, j = r;
        while (i < j) {
            while (array[j][mode] > piv) {
                j--;
            }

            while (array[i][mode] <= piv && i < j) {
                i++;
            }
            swap(array, i, j);
        }

        array[l] = array[i];
        array[i] = pivA;

        return i;
    }

    public static void swap(int[][] array, int a, int b) {
        int[] temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
