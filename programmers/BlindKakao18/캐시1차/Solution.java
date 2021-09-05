package programmers.BlindKakao18.캐시1차;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        String[] arr1 = { "Jeju", "Pangyo", "NewYork", "newyork" };
        Solution main = new Solution();
        System.out.println(main.solution(2, arr1));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();
            if (list.contains(str)) {
                answer += 1;
                list.remove(str);
                list.add(str);
            } else {
                answer += 5;
                if (list.size() == cacheSize && list.size() != 0)
                    list.remove(0);
                list.add(str);
            }
        }

        return answer;
    }
}
