package baekjoon.no15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] array, output;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        output = new int[M];
        visited = new boolean[N];

        for(int i = 0; i < N;) {
            array[i] = ++i;
        }

        dfs(0, 0);
        
        
        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int index) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = index; i < N - M + 1 + depth; i++) {
            output[depth] = array[i];
            dfs(depth + 1, i + 1);
        }
                 
    }
}
