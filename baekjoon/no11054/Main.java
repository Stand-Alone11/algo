package baekjoon.no11054;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO: ans referenced
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

        findInc();
        findDec();

        for (int i = 0; i < N; i++) {
            ans = Math.max(memoA[i] + memoD[i], ans);
        }
        System.out.println(ans - 1);
    }

    static void findInc() {
        for (int i = 0; i < N; i++) {
            memoA[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && memoA[i] < memoA[j] + 1) {
                    memoA[i] = memoA[j] + 1;
                }
            }
        }
    }

    static void findDec() {
        for (int i = N - 1; i >= 0; i--) {
            memoD[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (array[i] > array[j] && memoD[i] < memoD[j] + 1) {
                    memoD[i] = memoD[j] + 1;
                }
            }
        }
    }

}
