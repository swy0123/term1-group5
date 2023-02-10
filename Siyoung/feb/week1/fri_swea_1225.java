package algorithm.week1.fri;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * swea 1225 [S/W 문제해결 기본] 7일차 - 암호생성기
 */
public class fri_swea_1225 {
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
//		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();

			Queue<Integer> q = new LinkedList<>();
			for(int i=0; i<8; i++) {
				q .add(sc.nextInt());
			}
			
			int cnt = 1;
			int cur;
			while(q.peek() > 0) {
				cur = q.poll();
				if(cur > cnt) {
					q.offer(cur-cnt);
				}
				else {
					q.offer(0);
					break;
				}
				cnt++;
				if(cnt == 6) cnt = 1;
			}

			System.out.print("#"+test_case);
			for(int i=0; i<8; i++) {
				System.out.print(" "+ q.poll());
			}
			System.out.println();
			
			
		}
	}
}
