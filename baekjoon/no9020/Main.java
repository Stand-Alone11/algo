package baekjoon.no9020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {
            int in = Integer.parseInt(br.readLine());
            boolean[] primes = new boolean[in+1];
            ArrayList<Integer> primeNums = new ArrayList<>();

            app: for(int i = 2; i <= in; i++) {
                if(primes[i]) continue;

                if(i <= in) {
                    primeNums.add(i);
                    for(int j = 0; j < primeNums.size(); j++) {
                        if(i + primeNums.get(j) == in) {
                            System.out.println(primeNums.get(j)+" "+i);
                            break app;
                        }
                    }
                }

                for (int j = 2*i; j <= in; j += i) {
                    primes[j] = true;
                }
            }

        }
    }
}
