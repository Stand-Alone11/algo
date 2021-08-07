package baekjoon.no1427;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] array = new int[str.length()];

        for (int i = 0; i < array.length; i++) {
            array[i] = str.charAt(i) - '0';
        }

        for (int i = 0; i < array.length - 1; i++) {
            int max = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (max <= array[j]) {
                    max = array[j];
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result *= 10;
            result += array[i];
        }

        System.out.println(result);
        sc.close();
    }
}
