package programmers.BlindKakao18.다트게임1차;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solution("1S2D*3T");
    }

    public int solution(String dartResult) {
        char[] arr = dartResult.toCharArray();
        int[] ans = new int[3];

        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - '0' == 1 && arr[i + 1] - '0' == 0) {
                ans[++idx] = 10;
                i++;
            } else if (arr[i] - '0' > -1 && arr[i] - '0' < 10) {
                ans[++idx] = arr[i] - '0';
            } else if (arr[i] == 'D') {
                ans[idx] = ans[idx] * ans[idx];
            } else if (arr[i] == 'T') {
                ans[idx] = ans[idx] * ans[idx] * ans[idx];
            } else if (arr[i] == '*') {
                if (idx != 0)
                    ans[idx - 1] *= 2;
                ans[idx] *= 2;
            } else if (arr[i] == '#') {
                ans[idx] *= -1;
            }
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += ans[i];
        }

        return answer;
    }
}
