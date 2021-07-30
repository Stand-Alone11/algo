package baekjoon.no4153;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;

            int[] ary = {a, b, c};
            Arrays.sort(ary);

            if(ary[0]*ary[0] + ary[1]*ary[1] == ary[2]*ary[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}
