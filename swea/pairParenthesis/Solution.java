package swea.pairParenthesis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("algo/swea/pairParenthesis/pairParenthesis.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            Stack<Character> stk = new Stack<>();
            int leng = Integer.parseInt(br.readLine());
            String str = br.readLine();
            
            for(int i = 0; i < leng; i++) {
                if(stk.empty()) {
                    stk.add(str.charAt(i));
                } else if(stk.lastElement()-0 == str.charAt(i)-1 || stk.lastElement()-0 == str.charAt(i)-2) {
                    stk.pop();
                } else {
                    stk.add(str.charAt(i));
                }
            }

            if(stk.isEmpty())
                System.out.println("#" + tc + " " + 1);
            else 
                System.out.println("#" + tc + " " + 0);
        }
    }
}
