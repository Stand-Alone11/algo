package baekjoon.no11653;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input == 1) return;
        int i = 2;
        while(input != 1) {
            if(input % i == 0) {
                input = input / i;
                System.out.println(i);
            } else {
                i++;
            }

            if(input == 1) break;
        }
    }
}
