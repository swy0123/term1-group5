package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 15651 N과 M (4)
 * @author SSAFY
 *
 */
public class tue_baek_15652 {
	
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
		
		back(0, 0);
		System.out.print(sb);
	}
	
	private static void back(int cnt, int cur) {
		if(cnt == res.length) {
			for(int i=0; i<res.length; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=cur; i<arr.length; i++) {
			res[cnt] = arr[i];
			back(cnt+1, i);
		}
	}

}


