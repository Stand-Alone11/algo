package baekjoon.no11729;
import java.util.ArrayList;
//TODO: not solved
import java.util.Scanner;

public class Main {
    static int count = 0;
    static int i1 = -1;
    static int i2 = -1;
    static int i3 = -1;
    static int[] ary1, ary2, ary3;
    static ArrayList<String> aryLst = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ary1 = new int[N];
        ary2 = new int[N];
        ary3 = new int[N];

        for(int i = 0; i < N; i++) {
            ary1[++i1] = N-i;
        }

        hanoi(N);
    }

    public static void hanoi(int n) {
        if(!canMake(n)) {
            hanoi(n-1);
        }
    }

    public static boolean canMake(int n) {
        for(int i = 0; i <= i1; i++) {
            if(ary1[i] == n && i == i1) {
                return true;
            }
        }
        for(int i = 0; i <= i2; i++) {
            if(ary2[i] == n && i == i2) {
                return true;
            }
        }
        for(int i = 0; i <= i2; i++) {
            if(ary3[i] == n && i == i3) {
                return true;
            }
        }
        return false;
    }

    
}
