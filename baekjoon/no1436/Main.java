package baekjoon.no1436;

import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt() - 1;
        String ans = "666";

        int a = 666;
        while (N > 0) {
            a++;
            ans = String.valueOf(a);
            if (ans.contains("666"))
                N--;
        }

        System.out.println(ans);
        sc.close();
    }
}
