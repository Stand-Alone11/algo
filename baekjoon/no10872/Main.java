package baekjoon.no10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        System.out.println(fac(in));
        sc.close();
    }

    public static int fac(int in) {
        if(in == 0) return 1;
        if(in != 1) {
            return in * fac(in-1);
        } else {
            return 1;
        }

    }
}
