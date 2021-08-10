package baekjoon.no14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, N;
    static int[] inputs, operators, opArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        operators = new int[4]; // + - * /
        opArray = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int idx) {
        if (idx == N - 1) {
            int result = 0;
            for (int i = 0; i < N - 1; i++) {
                if (i == 0)
                    result = inputs[i];
                if (opArray[i] == 3 && inputs[i + 1] == 0)
                    return;
                switch (opArray[i]) {
                    case 0:
                        result += inputs[i + 1];
                        break;
                    case 1:
                        result -= inputs[i + 1];
                        break;
                    case 2:
                        result *= inputs[i + 1];
                        break;
                    case 3:
                        result /= inputs[i + 1];
                        break;
                }
            }
            if (result > max)
                max = result;
            if (result < min)
                min = result;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] != 0) {
                operators[i]--;
                opArray[idx] = i;
                dfs(idx + 1);
                opArray[idx] = 0;
                operators[i]++;
            }
        }
    }

}
