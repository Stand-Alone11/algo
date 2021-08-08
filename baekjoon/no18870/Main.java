package baekjoon.no18870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            array[i] = a;
        }

        int[] cArray = array.clone();
        Arrays.sort(cArray);

        int index = 0;
        for(int n : cArray) {
            if(!map.containsKey(n)) {
                map.put(n, index++);
            }
        }
        
        for(int n : array) {
            sb.append(map.get(n)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
