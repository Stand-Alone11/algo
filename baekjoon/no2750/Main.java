package baekjoon.no2750;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] array = new int[T];

        for (int i = 0; i < T; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        quick(array, 0, array.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 퀵소트 구현
    public static void quick(int[] array, int l, int r) {
        if (l >= r) { // 양쪽 범위가 만나면 끝
            return;
        }
        int piv = partition(array, l, r); // 핵심

        quick(array, l, piv - 1);
        quick(array, piv + 1, r);
    }

    public static int partition(int[] array, int l, int r) {
        int mid = (l + r) / 2;
        swap(array, l, mid); // 미드와 해당 범위의 첫 요소 바꿈

        int piv = array[l]; // 피봇은 배열의 첫번째 값 즉, 중간위치에 있었던 값
        int i = l, j = r;

        while (i < j) {
            while (piv < array[j]) { // 우측부터 피봇보다 같거나 작은값 찾기
                j--;
            }

            while (piv >= array[i] && i < j) { // 좌측부터 피봇보다 큰 값 찾기
                i++;
            }

            swap(array, i, j); // 작은값, 큰값 서로 바꾸기
        }
        array[l] = array[i]; // 찾은 작은 값을 맨 앞으로
        array[i] = piv; // 찾은 큰 값의 위치에 피봇 값으로 넣음
        return i; // 큰 값의 인덱스 리턴
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
