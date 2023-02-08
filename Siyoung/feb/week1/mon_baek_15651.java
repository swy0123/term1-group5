package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 15651 N과 M (3)
 * @author SSAFY
 *
 */
public class mon_baek_15651 {
	
	static int[] res;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		res = new int[m];
		
		for(int i=0; i<n; i++) { 
			arr[i] = i+1;
		}
		
		back(0);
		System.out.print(sb);
	}
	
	private static void back(int cnt) {
		if(cnt == res.length) {
			for(int i=0; i<res.length; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			res[cnt] = arr[i];
			back(cnt+1);
		}
	}

}


