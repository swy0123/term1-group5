package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 백준 3078 좋은 친구
 */
public class tue_baek_3078 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] name = new int[n];
		long res = 0;
		
		HashMap<Integer, Integer> dic = new HashMap<>();
		
		
		for(int i=0; i<n; i++) {
			name[i] = br.readLine().length();
//			System.out.println(name[i]);
			//한칸씩 이동하며 탐색
			if(i>k) {
				if(dic.get(name[i-k-1]) == 1) {
					dic.remove(name[i-k-1]);
				}
				else {
					dic.put(name[i-k-1], dic.get(name[i-k-1])-1);
				}
				
				if(dic.containsKey(name[i])) {

					res += dic.get(name[i]);
					dic.put(name[i], dic.get(name[i])+1);
				}
				else dic.put(name[i], 1);
			}
			//처음 k범위만큼 탐색
			else {
				if(dic.containsKey(name[i])) {
					res += dic.get(name[i]);
					dic.put(name[i], dic.get(name[i])+1);
				}
				else dic.put(name[i], 1);
			}
			
		}
		
		System.out.println(res);

	}
	

}
