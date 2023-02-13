package com.sy.secweek.thu;

import java.util.Scanner;
/**
 * [swea] 1493 : 수의새로운연산
 * @author swy05
 *
 */
public class thu_swea_1493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int p, q;
		int ret;
		
		for(int t=1; t<=T; t++) {
			p = sc.nextInt();
			q = sc.nextInt();
			
			int[] pxy = getXY(p);
			int[] qxy = getXY(q);
			
//			System.out.println(pxy[0] + " " + pxy[1]);
//			System.out.println(qxy[0] + " " + qxy[1]);
//			System.out.println((pxy[0]+qxy[0]) +" , "+ (pxy[1]+qxy[1]));
			ret = getNum(pxy[0]+qxy[0], pxy[1]+qxy[1]);
			
			System.out.println("#"+t+" "+ret);
			
		}
		
		
	}
	
	//좌표 확인
	static int[] getXY(int p) {
		int x = 1, y = 1;
		int[] xy = {x, y};
		
		int cur = 1, tmp = 1;
		while(cur<=p) {
			cur += tmp;
			tmp++;
			x++;
		}
		if(p == 1) {
			xy[0] = 1;
			xy[1] = 1;;
		}
		else{
			cur = cur-(tmp-1);
			y = y + (p-cur);
			x = x-y;
			xy[0] = x;
			xy[1] = y;
		}
		return xy;
	}
	//숫자 확인
	static int getNum(int x, int y) {
		int cur = 1;
		
		for(int i=1; i<x; i++) {
			cur += i;
		}
		for(int i=1; i<y; i++) {
			cur += x+i;
		}
		return cur;
	}

}
