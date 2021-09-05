package swea.gns;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder sb;
    static final String[] strs = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/gns/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int[] arr = new int[10];
            sb = new StringBuilder();
            br.readLine();
            String[] temp = br.readLine().split(" ");

            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < 10; j++) {
                    if (strs[j].equals(temp[i])) {
                        arr[j]++;
                        break;
                    }
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(strs[i]).append(" ");
                }
            }
            System.out.println("#" + tc + "\n" + sb.toString().trim());
        }
    }
}
