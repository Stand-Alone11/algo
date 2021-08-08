package baekjoon.no18870;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
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
            if(map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        Set<Integer> keys = map.keySet();
        for(int i = 0; i < N; i++) {
            int count = 0;
            for (Integer key : keys) {
                if(key < array[i]) count++;
            }
            sb.append(count).append(" ");
        }
        System.out.println(sb.toString());
    }
}
