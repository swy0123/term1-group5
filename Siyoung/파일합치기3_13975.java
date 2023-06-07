package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파일합치기3_13975 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t=0; t<test; t++) {
			int n = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long sum = 0;
			
			while(!pq.isEmpty()) {
				long num = pq.poll();
				if(!pq.isEmpty()) {
					num += pq.poll();
					sum+= num;
					pq.add(num);
				}
				else {
					System.out.println(sum);
				}
			}
			
		}
		
	}
}
