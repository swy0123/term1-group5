package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_19238 스타트 택시 골드2
 * 
 * @author elder
 *
 */
//행이 작은순, 열이 작은순
public class boj_19238 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row, col;

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static class customer {
		Point loc;
		Point target;

		public customer(Point loc, Point target) {
			super();
			this.loc = loc;
			this.target = target;
		}

		@Override
		public String toString() {
			return "customer [loc=" + loc + ", target=" + target + "]";
		}

	}

	static int N, M, fuel;
	static int[][] map;
	static Point My_car;
	static List<customer> customers;
	static boolean[] customers_status;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 운전을 시작하는 칸
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken()) - 1;
		int col = Integer.parseInt(st.nextToken()) - 1;
		My_car = new Point(row, col);
		customers_status = new boolean[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c_row = Integer.parseInt(st.nextToken()) - 1;
			int c_col = Integer.parseInt(st.nextToken()) - 1;
			int t_row = Integer.parseInt(st.nextToken()) - 1;
			int t_col = Integer.parseInt(st.nextToken()) - 1;

			customers.add(new customer(new Point(c_row, c_col), new Point(t_row, t_col)));
		}
		
		// find 가까운 친구 고르기
		while (customers.isEmpty()) {
			if(work()) {
				// -1
			}
		}
		// 고객으로 이동 -> 목적지로 이동

	}

	private static boolean work() {
		// 현재 서있는곳에 고객이 있나?
		
		// 가까운 승객 탐색
		Boolean[][] visited = new Boolean[N][N];
		Queue<Point> q = new LinkedList<Point>();
		visited[My_car.row][My_car.col] = true;
		q.offer(My_car);

		List<customer> client_now = new ArrayList<>();
		
		int size = 0;
		int level = 0;
		while (!q.isEmpty()) {
			size = q.size();
			if(client_now.size() > 0) {
				break;
			}
			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
						if(!visited[nr][nc]) {
							for(int c = 0; c < customers.size(); c++ ) {
								if(!customers_status[c]) {
									if(nr == customers.get(c).loc.row && nc == customers.get(c).loc.col) {
										client_now.add(customers.get(c));
									}
								}
							}
							
							visited[nr][nc] = true;
							q.offer(new Point(nr,nc));							
						}
					}
				}
			}
			level++;
		}
		
		Point Hello_customer = null;
		Point Hello_Target = null;
		// 고객 정하기
		int idx = -1;
		if(client_now.size() == 0) {
			return true;
		}else if(client_now.size() == 1) {
			Hello_customer = client_now.get(0).loc;
			Hello_Target = client_now.get(0).target;
		}else if(client_now.size() > 1) {
			Point current_loc = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
			for (int i = 0; i < client_now.size(); i++) {
				if(current_loc.row > client_now.get(i).loc.row) {
					idx = i;
					current_loc = client_now.get(i).loc;
				}else if(current_loc.row == client_now.get(i).loc.row) {
					if(current_loc.col > client_now.get(i).loc.col) {
						idx = i;
						current_loc = client_now.get(i).loc;
					}
				}
			}
			
			Hello_customer = current_loc;
			Hello_Target = client_now.get(idx).target;
		}
		
		
		//
		fuel -= level;
		if(fuel < 0) {
			return true;
		}
		
		//목적지로 이동하기
		visited = new Boolean[N][N];
		q = new LinkedList<Point>();
		visited[Hello_customer.row][Hello_customer.col] = true;
		q.offer(new Point(Hello_customer.row, Hello_customer.col));
		
		level = 0;
		while(!q.isEmpty()) {
			size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
			}
		}
		
		// 연료 계산하기, my_car 업데이트
	}

}
