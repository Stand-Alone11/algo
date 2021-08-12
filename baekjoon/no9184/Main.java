package baekjoon.no9184;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//TODO: ans checked
public class Main {
    static int[][][] m = new int[21][21][21]; // 어차피 같은 식으로 반복이므로 m 초기화 불필요
    static int a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] temp = br.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            c = Integer.parseInt(temp[2]);

            if (a == -1 && b == -1 && c == -1)
                break;

            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20)
            return m[20][20][20] = w(20, 20, 20);

        if (m[a][b][c] != 0)
            return m[a][b][c];

        if (a < b && b < c)
            return m[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        return m[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
