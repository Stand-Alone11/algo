package swea.balancePoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// no 145
public class Solution {
	static int N;
	static int[] locations, mass;
	static double[] balances;
	static double lMass, rMass;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			locations = new int[N];			
			mass = new int[N];
			balances = new double[N-1];
			
			StringBuffer sb = new StringBuffer();
			
			String temp[] = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				locations[i] = Integer.parseInt(temp[i]);
				mass[i] = Integer.parseInt(temp[i+N]);
			}
			
			findBalances();
			
			for(int i = 0; i < balances.length; i++) { // 찾은 지점 출력
				sb.append(String.format("%.10f", balances[i])).append(" ");
			}
			System.out.println("#"+tc+" "+sb.toString().trim());
		}
	}
	
	public static void findBalances() {
		for(int i = 0; i < N-1; i++) { // case는 n - 1개			
			balances[i] = n(i);
		}	
	}
	
	public static double n(int idx) {		
		double x = (double)(locations[idx] + locations[idx+1]) / (double)2;
		double leftEnd = locations[idx];
		double rightEnd = locations[idx+1];
		int counter = 100;
		//int counter = 41;
		
		double lF = getLeftForce(x, idx);
		double rF = getRightForce(x, idx);
		double tol = Math.pow(10, -6);
		
		while( counter >= 0) {
			counter--;
			if(lF < rF) { // 오른쪽이 세다면
				rightEnd = x; // 이전 x를 우측 end로 놓고 범위를 좁힘
				x = (x + leftEnd) / 2.0;				
			} else {      // 왼쪽이 세다면
				leftEnd = x; // 이전 x를 좌측 end로 놓고 범위를 좁힘
				x = (x + rightEnd) / 2.0;				
			}
			lF = getLeftForce(x, idx);
			rF = getRightForce(x, idx);
		}
		return x;
	}
	
	public static double getLeftForce(double x, int idx) {
		double force = 0;
		for(int i = 0; i <= idx; i++) {
			force += mass[i] / Math.pow(x-locations[i], 2);
		}
		return force;
	}
	
	public static double getRightForce(double x, int idx) {
		double force = 0;
		for(int i = idx + 1; i < N; i++) {
			force += mass[i] / Math.pow(x-locations[i], 2);
		}
		return force;		
	}
	
	
}

