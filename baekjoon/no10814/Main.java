package baekjoon.no10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        Main main = new Main();
        main.solve();
    }

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<User> userL = new ArrayList<User>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            userL.add(new User(i, Integer.parseInt(temp[0]), temp[1])); 
        }

        Collections.sort(userL);
        for (User user : userL) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }
        System.out.println(sb.toString());
    }

        class User implements Comparable<User> {
        int index, age;
        String name;

        User(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            User user = o;
            if(age < user.age) {
                return -1;
            } else if (age == user.age) {
                if(index < user.index) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

    }
}
