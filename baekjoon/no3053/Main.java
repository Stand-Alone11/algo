package baekjoon.no3053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        double areaC = in*in*Math.PI;
        double areaT = 2*in*in;

        System.out.printf("%.6f\n", areaC);
        System.out.printf("%.6f ", areaT);

        sc.close();
    }
}
