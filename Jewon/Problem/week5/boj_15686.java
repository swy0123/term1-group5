package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_15686 치킨 배달 골드 5
 * 
 * @author SSAFY
 *
 */
public class boj_15686 {
	static int N;
	static int M;
//	static int[][] map;
	static List<Point> chickenList = new ArrayList<Point>();
	static List<Point> houseList = new ArrayList<Point>();
	static Point[] temparr;
	static int ansDist = Integer.MAX_VALUE;
	
	static class Point {
		int row;
		int col;
		
		public static int getdist(Point p1, Point p2) {
			
			return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);
		}
		
		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		map = new int[N][N];
		
		temparr = new Point[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if (temp == 1) {
					houseList.add(new Point(i,j));
				}
				
				if (temp == 2) {
					chickenList.add(new Point(i,j));
				}

			}
		}
		
		// chickenList 에서  M개를 선택 조합
		recur(0,0);
		// houselist와 모든 도시의 치킨 거리 구함
		// 그중 최소의 거리를 탐색한다.
		System.out.println(ansDist);
		
	}

	private static void recur(int depth, int start) {
		// TODO Auto-generated method stub
		if(depth == M) {
			int sum = 0;
			
			for (int i = 0; i < houseList.size(); i++) {
				sum += getmindist(houseList.get(i));
			}
			
			ansDist = Math.min(ansDist, sum);
			
			return;
		}
		
		for (int i = start; i < chickenList.size(); i++) {
			temparr[depth] = chickenList.get(i);
			recur(depth+1 , i+1);
		}
	}
	
	//고른 치킨집과 집의 최소 거리를 구하는 매서드
	private static int getmindist(Point point) {
		int mindist = Integer.MAX_VALUE;
		
		for (int i = 0; i < temparr.length; i++) {
			mindist = Math.min(mindist, Point.getdist(point, temparr[i]));
		}
		return mindist;
	}

}
