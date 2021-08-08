package baekjoon.no1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<String>[] array = new ArrayList[51];
        for (int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean flag = false;

            for (int j = 0; j < array[str.length()].size(); j++) {
                if (str.equals(array[str.length()].get(j))) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;

            array[str.length()].add(str);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].size() > 1) {
                Object[] a = array[i].toArray();
                Arrays.sort(a);
                for (int j = 0; j < a.length; j++) {
                    sb.append(a[j]).append("\n");
                }
            } else if (array[i].size() != 0) {
                sb.append(array[i].get(0)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
