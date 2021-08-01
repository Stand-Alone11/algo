package baekjoon.no11729;
import java.util.ArrayList;
//TODO: not solved
import java.util.Scanner;

public class Main {
    static int count = 0;
    static int i1 = -1;
    static int i2 = -1;
    static int i3 = -1;
    static ArrayList<String> aryLst = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] ary1 = new int[N];
        int[] ary2 = new int[N];
        int[] ary3 = new int[N];

        for(int i = 0; i < N; i++) {
            ary1[++i1] = N-i;
        }

        hanoi(N);
    }

    public static void hanoi(int n) {
        count++;

        
        
    }

    
}
