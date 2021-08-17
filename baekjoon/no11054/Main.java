package baekjoon.no11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO: not solved
public class Main {
    static int N;
    static int[] array;
    static Integer[] memoA;
    static Integer[] memoD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        memoA = new Integer[N];
        memoD = new Integer[N];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            ans = Math.max(findInc(i) + findDec(i), ans);
        }
        System.out.println(ans);
    }

    static int findInc(int idx) {
        int mx;
        for (int i = idx; i >= 0; i++) {

        }

    }

    static int findDec(int idx) {

    }

}
