package swea.power;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int tcNum = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("algo/swea/power/power.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int tc = 1; tc <= T; tc++) {
            sc.nextInt();
            tcNum = tc;
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            f(a, b, 1);
        }
    }

    public static void f(int a, int b, int c) {
        if(b >= 1) {
            f(a, b-1, c*a);
        } else {
            System.out.println("#"+tcNum+" "+c);
        }
    }
}
