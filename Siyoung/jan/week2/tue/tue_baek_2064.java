package com.sy.secweek.tue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 문제31: 백준 : 2164 카드2 Queue
 * @author swy05
 */
public class tue_baek_2064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		int res=1;
		while(true) {
			res = q.remove();
			if(!q.isEmpty()) q.add(q.poll());
			else break;
		}
		System.out.println(res);

	}

}
