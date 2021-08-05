package baekjoon.no2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int a = 0;
        int sum = 0;
        while (true) {
            a++;
            String str = String.valueOf(a);
            sum = a;
            for (int i = 0; i < str.length(); i++) {
                sum += (str.charAt(i) - '0');
            }
            if (sum == N) {
                System.out.println(a);
                break;
            }
            if (sum > 1000000) {
                System.out.println(0);
                break;
            }
        }
    }

}
