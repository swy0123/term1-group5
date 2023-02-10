package algorithm.week1.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 1107 리모컨
 */
public class fir_baek_1107 {
	static int min;
	static int n;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = br.readLine();
		n = Integer.parseInt(input);
		int m = Integer.parseInt(br.readLine());
		
		int cur = 100;
		int r = input.length();
		min = Math.abs(n - cur);
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = i;
		}
		int cnt = 0;
		if(m>0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				arr[Integer.parseInt(st.nextToken())] = -1;
				cnt++;
			}
		}
		
		int[] num = new int[10-cnt];
		cnt = 0;
		for(int i=0; i<10; i++) {
			if(arr[i] != -1) {
				num[cnt] = arr[i];
				cnt++;
			}
		}
		
//		System.out.println(Arrays.toString(num));
		if(r>1) {
			count(num, 0, r-1, r-1);
		}
		count(num, 0, r, r);
		count(num, 0, r+1, r+1);
		
		System.out.println(min);

	}
	
	static void count(int[] num, int cur, int cnt, int r) {
		if(cnt == 0) {
//			System.out.println(cur + " " +Math.abs(n-cur) +" "+ r);
			if(cur == 0) r=1;
			min = Math.min(min, Math.abs(n-cur)+r);
			return;
		}
		int tmp = cur;
		for(int i=0; i<num.length; i++) {
			count(num, cur*10+num[i], cnt-1, r);
		}
	}
	

}
