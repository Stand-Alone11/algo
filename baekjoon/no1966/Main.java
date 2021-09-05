package baekjoon.no1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> q1 = new LinkedList<>();
            int N = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int counter = 0;

            for (int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken()));
                if (i == id) {
                    q1.add(1);
                } else {
                    q1.add(0);
                }
            }

            while (true) {
                int f = q.poll();
                int a = q1.poll();
                boolean flag = false;

                for (Integer integer : q) {
                    if (f < integer) {
                        q.add(f);
                        q1.add(a);
                        flag = true;
                        break;
                    }
                }
                if (!flag && a == 1) {
                    break;
                } else if (!flag && a == 0) {
                    counter++;
                }
            }

            sb.append(counter + 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
