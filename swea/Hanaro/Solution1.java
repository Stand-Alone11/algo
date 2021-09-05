package swea.Hanaro;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1 {
    static long[] x, y;
    static PriorityQueue<Vertex> queue;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/Hanaro/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            x = new long[N];
            y = new long[N];
            boolean[] selected = new boolean[N];
            long ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { // 좌표 세팅
                x[i] = Long.parseLong(st.nextToken());
                y[i] = Long.parseLong(st1.nextToken());
            }
            double tax = Double.parseDouble(br.readLine()); // 세율 세팅
            queue = new PriorityQueue<>();
            queue.add(new Vertex(0, 0));

            while (!queue.isEmpty()) {
                Vertex u = queue.poll();
                if (selected[u.node]) {
                    continue;
                }
                ans += u.key; // 답 더하기
                selected[u.node] = true;
                for (int i = 0; i < N; i++) { // 그래프가 정해진 게 없어 모든 경로 탐색
                    if (!selected[i]) { // 선택되지 않은 i 만
                        long dis = getDistance(i, u.node); // i, u의 거리
                        queue.add(new Vertex(i, dis));
                    }
                }
            }
            System.out.println("#" + tc + " " + Math.round(ans * tax));
        }
    }

    public static long getDistance(int a, int b) {
        return (long) (Math.pow(x[a] - x[b], 2) + Math.pow(y[a] - y[b], 2));
    }

    static class Vertex implements Comparable<Vertex> {
        public int node;
        public long key;

        public Vertex(int node, long key) {
            this.node = node;
            this.key = key;
        }

        @Override
        public int compareTo(Vertex o) {
            return Long.compare(this.key, o.key);
        }
    }

}
