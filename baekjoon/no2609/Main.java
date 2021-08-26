package baekjoon.no2609;

import java.util.Scanner;

public class Main {
    static int gcf = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        if (a > b) {
            if (b == 1) {
                gcf = 1;
            } else {
                for (int i = b; i > 1; i--) {
                    if (b % i == 0) {
                        if (a % i == 0) {
                            gcf = i;
                            break;
                        }
                    }
                }
            }
        } else {
            if (a == 1) {
                gcf = 1;
            } else {
                for (int i = a; i > 1; i--) {
                    if (a % i == 0) {
                        if (b % i == 0) {
                            gcf = i;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(gcf);
        System.out.println(gcf * (a / gcf) * (b / gcf));
    }
}
