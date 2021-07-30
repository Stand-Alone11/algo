package baekjoon.no3009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[4];
        int[] y = new int[4];
        String ans = "";

        for(int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for(int i = 0; i < 3; i++) {
            if(x[(0+i)%3] == x[(1+i)%3]) {
                x[(0+i)%3] = 0;
                x[(1+i)%3] = 0;
            }
        }

        for(int i = 0; i < 3; i++) {
            if(y[(0+i)%3] == y[(1+i)%3]) {
                y[(0+i)%3] = 0;
                y[(1+i)%3] = 0;
            }
        }

        for(int i = 0; i < 4; i++) {
            if(x[i] != 0) ans = ans + x[i];
        }

        for(int i = 0; i < 4; i++) {
            if(y[i] != 0) ans = ans + " " + y[i];
        }

        System.out.println(ans);
        sc.close();


    }
}
