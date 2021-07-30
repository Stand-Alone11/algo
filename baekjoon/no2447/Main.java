package baekjoon.no2447;

import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        grid = recur(N);
        for(int i = 0; i < grid[0].length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]);
            }
            System.out.println(sb.toString());
            sb = new StringBuilder();
        }
        sc.close();
    }
    public static char[][] recur(int n) {
        if(n == 3) {
            char[][] a = {{'*','*','*'},{'*',' ','*'},{'*','*','*'}};
            return a;
        } else {
            char[][] a = new char[n][n];
            char[][] unit = recur(n/3);
            
            return set(unit, a);
        }

    }
    public static char[][] set(char[][] unit, char[][] plate) {
        int pleng = plate[0].length; // 27 9
        int uleng = unit[0].length; //   9 3

        for(int i = 0; i < pleng; i++) {
            for(int j = 0; j < pleng; j++) {
                if(i >= uleng && i < 2*uleng && j >= uleng && j < uleng*2) {
                    plate[i][j] = ' ';
                } else {
                    plate[i][j] = unit[i%uleng][j%uleng];
                }
            }
        }

        return plate;
    }
}

