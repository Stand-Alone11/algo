package baekjoon.no15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] array, output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        array = new int[N];
        output = new int[M];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N;) {
            array[i] = ++i;
        }

        dfs(0, visited);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth, boolean[] visited) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = array[i];
                dfs(depth + 1, visited);
            }
        }
    }


}
