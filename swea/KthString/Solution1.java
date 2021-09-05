package swea.KthString;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/KthString/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[][] sufA = new String[str.length()][3]; // [i][0]: string, [i][1]: 시작 idx, [i][2]: lcp
            for (int i = 0; i < str.length(); i++) {
                sufA[i][0] = str.substring(i, str.length());
                sufA[i][1] = String.valueOf(i);
            }

            Arrays.sort(sufA, new Comparator<String[]>() {

                @Override
                public int compare(String[] o1, String[] o2) {
                    return o1[0].compareTo(o2[0]);
                }

            });

            for (int i = 0; i < str.length() - 1; i++) {
                String a = sufA[i][0];
                String b = sufA[i + 1][0];

                sufA[i + 1][2] = String.valueOf(getLcp(a, b));
            }
            sufA[0][2] = String.valueOf(0);

            String ans = null;
            int sum = 0;
            for (int i = 0; i < sufA.length; i++) {
                int num = str.length() - Integer.parseInt(sufA[i][1]) - Integer.parseInt(sufA[i][2]);
                sum += num;
                if (sum >= K) {
                    int j = K - sum + num + Integer.parseInt(sufA[i][2]);
                    ans = sufA[i][0].substring(0, j);
                    break;
                }
            }
            ans = ans == null ? "none" : ans;
            System.out.println("#" + tc + " " + ans);
        }
    }

    static int getLcp(String a, String b) {
        int counter = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }
}
