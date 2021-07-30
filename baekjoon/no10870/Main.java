package baekjoon.no10870;

import java.util.Scanner;

public class Main {

    static int[] ary = new int [21];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(fibo(n));
        sc.close();
    }

    public static int fibo(int n) {
        if(n == 0) {
            ary[0] = 0;
            return ary[0];
        }
        if(n == 1) {
            ary[1] = 1;
            return ary[1];
        }
        if(ary[n] == 0) {
            ary[n] = fibo(n-1) + fibo (n-2);
        }
        return ary[n];
    }
}
