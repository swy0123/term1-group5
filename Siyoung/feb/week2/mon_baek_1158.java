package algorithm.week2;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 백준 1158 요세푸스 문제
 */
public class mon_baek_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			cnt++;
			if(cnt==m) {
				cnt = 0;
				sb.append(q.poll());
				if(!q.isEmpty()) {
					sb.append(", ");
				}
				else sb.append(">");
			}
			else {
				q.offer(q.poll());
			}
		}
		
		System.out.println(sb);
	}

}
