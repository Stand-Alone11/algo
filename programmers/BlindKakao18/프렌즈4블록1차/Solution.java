package programmers.BlindKakao18.프렌즈4블록1차;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        String[] arr1 = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
        String[] arr2 = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

        System.out.println(main.solution(6, 6, arr2));
        System.out.println(main.solution(4, 5, arr1));

    }

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;

        while (true) {
            boolean[][] checked = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1]
                            && map[i][j] != '0') {
                        checked[i][j] = checked[i][j + 1] = checked[i + 1][j] = checked[i + 1][j + 1] = true;
                    }
                }
            }
            int sum = getPop(map, checked);
            if (sum == 0) {
                break;
            } else {
                answer += sum;
                map = move(map);
            }
        }
        return answer;
    }

    public int getPop(char[][] map, boolean[][] checked) {
        int counter = 0;
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                if (checked[i][j]) {
                    map[i][j] = '0';
                    counter++;
                }
            }
        }
        return counter;
    }

    public char[][] move(char[][] map) {
        int m = map.length;
        int n = map[0].length;
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] == '0') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '0') {
                            map[i][j] = map[k][j];
                            map[k][j] = '0';
                            break;
                        }
                    }
                }
            }
        }
        return map;
    }

}
