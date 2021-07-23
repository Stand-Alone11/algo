package baekjoon.no10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            st.nextToken();
            int guest = Integer.parseInt(st.nextToken());

            int floor = guest%h;
            int room = guest/h;
            String output;

            if(floor == 0) {
                floor = h;
            } else {
                room++;
            }
            if(room < 10) {
                if(floor == 0) floor = 1;
                output = String.valueOf(floor)+"0"+String.valueOf(room);
            } else {
                output = String.valueOf(floor)+String.valueOf(room);
            }
            System.out.println(output);
        }
         

    }
}