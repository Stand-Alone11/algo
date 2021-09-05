package swea.KthString;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("swea/KthString/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine()) - 1;
            String str = br.readLine();
            TreeMap<String, Integer> map = new TreeMap<>();

            for (int i = 0; i < str.length(); i++) {
                for (int j = i + 1; j < str.length() + 1; j++) {
                    map.put(str.substring(i, j), 0);
                }
            }

            int counter = -1;
            for (String s : map.keySet()) {
                counter++;
                if (counter == K) {
                    System.out.println("#" + tc + " " + s);
                    break;
                }
            }
        }
    }
}
