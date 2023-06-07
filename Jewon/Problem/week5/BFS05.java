package ssafy.day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS05 {
	static int[][] map;
	static int level = -1;
	/*
	 * 사방으로 연결된 1의 덩어리의 개수 세기
	 */
	static int N = 6;
	static int M = 6;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("bfs05.txt"));

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs();

		System.out.println(level);
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	// 최단거리 구하기
	private static void bfs() {
		// 1.Queue를 만든다.
		Queue<Point> q = new LinkedList<Point>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}

		// 3.Queue가 빌때 까지 반복하는데
		while (!q.isEmpty()) {
			level++;
			int size = q.size();

			for (int cnt = 0; cnt < size; cnt++) {
				Point p = q.poll();

				map[p.r][p.c] = 1;

				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];

					if (nc >= 0 && nc < M && nr >= 0 && nr < N && map[nr][nc] == 0) {
						q.add(new Point(nr, nc));
					}
				}
			}
			print();
			// 4.하나를 폴링하고 빠진 노드와 관련있는 노드를 큐에 넣음
		}

	}
	
	public static void print() {
		System.out.println("------------------------");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
