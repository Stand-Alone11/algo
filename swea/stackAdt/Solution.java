package swea.stackAdt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static char[] ary;
    public static int index = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        ary = new char[str.length()];

        for(int i = 0; i < ary.length; i++) {
            if(isEmpty()) {
                add(str.charAt(i));
            } else {
                if(str.charAt(i)-1 == ary[index]-0) {
                    pop();
                } else {
                    add(str.charAt(i));
                }
            }
        }

        if(isEmpty()) System.out.println(1);
        else System.out.println(0);
    }

    public static void pop() {
        ary[index--] = '\u0000';
    }

    public static void add(char c) {
        ary[++index] = c;
    }

    public static boolean isEmpty() {
        if(index == -1) return true;
        return false;
    }
}