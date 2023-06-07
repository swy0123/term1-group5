package algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;
/*
 * 백준 6987 월드컵
 */
public class wed_baek_6987 {
	static int[][] board;
	static int res;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int k=0; k<4; k++) {
			st = new StringTokenizer(br.readLine());
			board = new int[6][3];
			res = 0;
			flag = false;
			int game = 0;
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					game += board[i][j];
				}
			}
			if(game%2==0) {
				solve(0, 1);
			}
			sb.append(res+" ");
		}
		System.out.println(sb);
	}
	
//	a b c d e f
//	b c d e f
//	c d e f
//	d e f
//	e f
//	f
	private static void solve(int team1, int team2) {
		if(flag) {
			return;
		}
		
		if(team1==5 && check()) {
			res = 1;
			flag = true;
			return;
		}
		
		if(team1==5) {
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(board[team1][i] > 0) {
				if(i==1) {
					board[team1][i]--;
					board[team2][i]--;
				}
				if(i==0) {
					board[team1][i]--;
					board[team2][2]--;
				}
				if(i==2){
					board[team1][i]--;
					board[team2][0]--;
				}
				if(team2==5) {
					solve(team1+1, team1+2);
				}
				else {
					solve(team1, team2+1);
				}
				if(i==1) {
					board[team1][i]++;
					board[team2][i]++;
				}
				if(i==0) {
					board[team1][i]++;
					board[team2][2]++;
				}
				if(i==2){
					board[team1][i]++;
					board[team2][0]++;
				}
			}
		}
	}
	
	private static boolean check() {
		for (int[] is : board) {
			for (int i : is) {
				if(i!=0)return false;
			}
		}
		return true;
	}
	
}
