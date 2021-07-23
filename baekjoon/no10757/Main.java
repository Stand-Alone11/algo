package baekjoon.no10757;

import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int longLength = (a.length() > b.length()) ? a.length() : b.length();
        
        int sur = 0; // 1 올림
        for(int i = 0; i < longLength; i++) {
            
            int aNum;
            int bNum;

            try {
                aNum = a.charAt(a.length() - 1 - i) - 48;
            } catch (StringIndexOutOfBoundsException e ) {
                aNum = 0;
            } catch (NullPointerException e1) {
                aNum = 0;
            }

            try {
                bNum = b.charAt(b.length() - 1 - i) - 48;
            } catch (StringIndexOutOfBoundsException e) {
                bNum = 0;
            } catch (NullPointerException e1){
                bNum = 0;
            }
            
            if(i != longLength - 1) {
                if((aNum + bNum + sur) >= 10) {
                    sb.append(String.valueOf((aNum + bNum + sur)%10));
                    sur = 1;
                } else {
                    sb.append(String.valueOf((aNum + bNum + sur)%10));
                    sur = 0;
                }
            } else {
                if((aNum + bNum + sur) >= 10) {
                    sb.append(String.valueOf((aNum + bNum + sur)%10)).append("1");
                } else {
                    sb.append(String.valueOf((aNum + bNum + sur)%10));
                }
            }
            

        }
        
        for(int j = 0; j < sb.toString().length(); j++) {
            sb2.append(sb.toString().charAt(sb.toString().length() - 1 - j));
        }
        System.out.println(sb2.toString());
    }
}
