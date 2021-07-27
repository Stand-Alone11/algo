package baekjoon.no1011;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//TODO: not solved
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int start, end;
        

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            ArrayList<Integer> array = new ArrayList<>();

            int distance = end - start;
        
            array.add(0);
            array.add(1);
            array.add(2);

            if(distance == 1) {
                System.out.println(array.get(distance));
                return;
            }

            if(distance == 2) {
                System.out.println(array.get(distance));
                return;
            }

            int count = 2;
            int value = 3;
            
            all: while(distance != array.size() - 1) {
                for(int a = 0; a < 2; a++) {
                    for(int b = 0; b < count; b++) {
                        array.add(value);
                        if(array.size() - 1 == distance) {
                            break all;
                        }

                    }
                    value++;
                }
                count++;
            }
        
            System.out.println(array.get(distance));
            
        }
    }
}
