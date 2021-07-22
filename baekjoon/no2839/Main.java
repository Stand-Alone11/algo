package baekjoon.no2839;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        
        int x = (int)a/5;
        int y = a%5;

        while(true) {
            if(y%3 == 0) {
                System.out.println(x+y/3);
                break;
            }
            x--;
            y = a-x*5;
            if(x<0) {
                System.out.println(-1);
                break;
            }
        }
    }
}
