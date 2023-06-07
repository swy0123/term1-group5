package algorithm.week1.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 12891 DNA 비밀번호
 */
public class thu_baek_12891 {
	static String[] dna =  {"A", "C", "G", "T"};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int res = 0;
		
		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[4];
		int[] cnt = {0, 0, 0, 0};
		
		for(int i=0; i<4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		
		String tmp = str.substring(0, p);
		for(int i=0; i<p; i++) {
			if(tmp.charAt(i) == 'A') cnt[0]++;
			else if(tmp.charAt(i) == 'C') cnt[1]++;
			else if(tmp.charAt(i) == 'G') cnt[2]++;
			else if(tmp.charAt(i) == 'T') cnt[3]++;
		}
		for(int i=0; i<4; i++) {
			if(arr[i] > cnt[i]) flag = false;
		}
		if(flag) res++;
//		System.out.println(Arrays.toString(cnt));
		
		for(int i=0; i<=s-p; i++) {
			flag = true;
			if(i+p == s) break;
			if(str.charAt(i) == 'A') cnt[0]--;
			else if(str.charAt(i) == 'C') cnt[1]--;
			else if(str.charAt(i) == 'G') cnt[2]--;
			else if(str.charAt(i) == 'T') cnt[3]--;
			
			if(str.charAt(i+p) == 'A') cnt[0]++;
			else if(str.charAt(i+p) == 'C') cnt[1]++;
			else if(str.charAt(i+p) == 'G') cnt[2]++;
			else if(str.charAt(i+p) == 'T') cnt[3]++;

//			System.out.println(Arrays.toString(cnt));
			for(int j=0; j<4; j++) {
//				System.out.println(arr[j] +" "+ cnt[j]);
				if(arr[j] > cnt[j]) flag = false;
			}
			if(flag) res++;
			
		}
		
		
//		comb(str, arr, "", cnt);
		System.out.println(res);
	}

}
