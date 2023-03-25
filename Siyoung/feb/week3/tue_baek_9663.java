package algorithm.week3;

import java.util.Scanner;
/*
 * 백준 9663 N-Queen
 */
public class tue_baek_9663 {
	static int n, col[], answer=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		col = new int[n+1];
		
		setQueen(1);
		System.out.println(answer);
	}

	private static void setQueen(int rowNo) { // rowNo : 놓으려고 하는 퀸의 행번호
		if(!isAvailable(rowNo-1)) return;
		
		if(rowNo>n) {
			answer++;
			return;
		}
		
		for(int i=1; i<=n; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	private static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) { // i : 비교 대상 퀸의 행번호
			if(col[i]==col[rowNo]) return false;
			if(Math.abs(col[i]-col[rowNo])==rowNo-i) return false;
		}
		return true;
	}
}
