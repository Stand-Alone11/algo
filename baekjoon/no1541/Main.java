package baekjoon.no1541;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = br.readLine().split("\\-");
        int sum = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (i != 0) {
                String[] strAry = strArray[i].split("\\+");
                for (int j = 0; j < strAry.length; j++) {
                    sum -= Integer.parseInt(strAry[j]);
                }
            } else {
                String[] strAry = strArray[i].split("\\+");
                for (int j = 0; j < strAry.length; j++) {
                    sum += Integer.parseInt(strAry[j]);
                }
            }
        }

        System.out.println(sum);
    }
}
