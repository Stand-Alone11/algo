package baekjoon.no1085;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[] array = {x, w-x, y, h-y};
        Arrays.sort(array);

        System.out.println(array[0]);
        sc.close();
    }
}
