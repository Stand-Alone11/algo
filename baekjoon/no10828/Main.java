package baekjoon.no10828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stck = new int[10000];
        int idx = -1;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            if (str1.equals("push")) {
                stck[++idx] = Integer.parseInt(st.nextToken());
            } else if (str1.equals("top")) {
                if (idx == -1) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stck[idx]).append("\n");
                }
            } else if (str1.equals("pop")) {
                if (idx != -1)
                    sb.append(stck[idx--]).append("\n");
                else
                    sb.append(-1).append("\n");
            } else if (str1.equals("size")) {
                sb.append(idx + 1).append("\n");
            } else if (str1.equals("empty")) {
                if (idx == -1) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
