package programmers.BlindKakao18.뉴스클러스터링1차;

import java.util.ArrayList;

public class Solution {
    static double sizeOfUnion, sizeOfCommon;

    public static void main(String[] args) {
        Solution main = new Solution();
        String[] arr1 = { "FRANCE", "handshake", "aa1+aa2", "E=M*C^2" };
        String[] arr2 = { "french", "shake hands", "AAAA12", "e=m*c^2" };
        for (int i = 0; i < arr1.length; i++) {
            sizeOfUnion = sizeOfCommon = 0;
            System.out.println(main.solution(arr1[i], arr2[i]));
        }
    }

    public int solution(String str1, String str2) {
        // public double solution(String str1, String str2) {
        String strL1 = str1.toLowerCase();
        String strL2 = str2.toLowerCase();

        ArrayList<String> arr1 = getSubsets(strL1);
        ArrayList<String> arr2 = getSubsets(strL2);

        // int answer = (int) getJ(arr1, arr2);
        double answer = getJ(arr1, arr2);

        return (int) (answer * 65536);
    }

    boolean isLetter(char a) {
        int as = a - 0;
        if (as >= 97 && as <= 122)
            return true;
        return false;
    }

    ArrayList<String> getSubsets(String str) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (isLetter(str.charAt(i)) && isLetter(str.charAt(i + 1))) {
                arr.add(str.substring(i, i + 2));
            }
        }
        return arr;
    }

    double getJ(ArrayList<String> arr1, ArrayList<String> arr2) {
        boolean[] checked1 = new boolean[arr1.size()];
        boolean[] checked2 = new boolean[arr2.size()];
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
                if (arr1.get(i).equals(arr2.get(j)) && !checked1[i] && !checked2[j]) {
                    checked1[i] = true;
                    checked2[j] = true;
                    sizeOfCommon++;
                    break;
                }
            }
        }
        if (arr1.size() == 0 && arr2.size() == 0)
            return 1;
        return sizeOfCommon / (double) (arr1.size() + arr2.size() - sizeOfCommon);
    }
}
