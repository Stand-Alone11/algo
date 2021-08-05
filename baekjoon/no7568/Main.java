package baekjoon.no7568;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[N][4];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            grid[i][0] = sc.nextInt();
            grid[i][1] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][0] < grid[j][0] && grid[i][1] < grid[j][1]) {
                    grid[i][2]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(grid[i][2] + 1).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
