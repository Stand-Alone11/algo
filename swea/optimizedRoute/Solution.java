package swea.optimizedRoute;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
    static int[][] coords, distances;
    static boolean[] visited;
    static int[] array;
    static int ans, N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("swea/optimizedRoute/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 좌표 세팅
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;
            coords = new int[N + 2][2];
            distances = new int[N + 2][N + 2];
            visited = new boolean[N + 2];
            st = new StringTokenizer(br.readLine());
            coords[0][0] = Integer.parseInt(st.nextToken());
            coords[0][1] = Integer.parseInt(st.nextToken());
            coords[N + 1][0] = Integer.parseInt(st.nextToken());
            coords[N + 1][1] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                coords[i][0] = Integer.parseInt(st.nextToken());
                coords[i][1] = Integer.parseInt(st.nextToken());
            }
            // 좌표 세팅 끝 / 1..N

            for (int i = 0; i <= N + 1; i++) {
                for (int j = 0; j <= N + 1; j++) {
                    getDistance(i, j);
                }
            }

            array = new int[N];
            recur(0);

            System.out.println("#" + tc + " " + ans);
        }

    }

    static void recur(int depth) {

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i;
                if (depth == N - 1) {
                    int val = getAns(array);
                    if (val < ans)
                        ans = val;
                } else {
                    recur(depth + 1);
                }
                array[depth] = 0;
                visited[i] = false;
            }
        }
    }

    static int getDistance(int start, int dest) {
        if (distances[start][dest] == 0) {
            distances[dest][start] = distances[start][dest] = Math.abs(coords[start][0] - coords[dest][0])
                    + Math.abs(coords[start][1] - coords[dest][1]);
        }
        return distances[start][dest];
    }

    static int getAns(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += getDistance(arr[i], arr[i + 1]);
        }
        sum += getDistance(0, arr[0]) + getDistance(arr[arr.length - 1], N + 1);
        return sum;
    }
}
