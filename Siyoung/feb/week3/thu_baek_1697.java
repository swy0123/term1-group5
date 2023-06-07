package algorithm.week3.thu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 백준 1697 숨바꼭질
 */
public class thu_baek_1697 {
	static class point{
		int i, cnt;

		public point(int i, int cnt) {
			super();
			this.i = i;
			this.cnt = cnt;
		}
	}
	static boolean[] v = new boolean[100001];
	static int n, k, min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		min = -1;
		if(n!=k) {
			find();
		}
		else min = 0;
		System.out.println(min);
	}
	
	private static void find() {
		int m = v.length;
		Queue<point> q = new LinkedList<>();
		q.add(new point(n, 0));
		v[n] = true;
		
		
		while(!q.isEmpty()) {
			point p = q.poll();
//			System.out.println(p.i +" "+ p.cnt);
			if(p.i*2<m && !v[p.i*2]) {
				if(p.i*2==k) {
					min = p.cnt+1;
					break;
				}
				else {
					q.add(new point(p.i*2, p.cnt+1));
					v[p.i*2] = true;
				}
			}
			if(p.i+1<m && !v[p.i+1]) {
				if(p.i+1==k) {
					min = p.cnt+1;
					break;
				}
				else {
					q.add(new point(p.i+1, p.cnt+1));
					v[p.i+1] = true;
				}
			}
			if(p.i-1>=0 && !v[p.i-1]) {
				if(p.i-1==k) {
					min = p.cnt+1;
					break;
				}
				else {
					q.add(new point(p.i-1, p.cnt+1));
					v[p.i-1] = true;
				}
			}
		}
		
		
	}

}
