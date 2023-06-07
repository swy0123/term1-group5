package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * 백준 골드5 2493 탑
 */
public class tue_baek_2493 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		int[] arr = new int[n];
		int num;
		
		for(int i=0; i<n; i++) {
			num = Integer.parseInt(st.nextToken());
//			idx.add(i);
			if(!st1.empty()) {
				while(st1.peek() < num) {
					st1.pop();
					idx.pop();
					if(st1.empty()) break;
				}
				if(st1.empty()) {
					arr[i] = 0;
					st1.add(num);
					idx.add(i+1);
				}
				else {
					arr[i] = idx.peek();
					st1.add(num);
					idx.add(i+1);
				}
			}
			else {
				arr[i] = 0;
				st1.add(num);
				idx.add(i+1);
			}
			
		}

		for (int i : arr) {
			System.out.print(i +" ");
		}
		

	}

}
