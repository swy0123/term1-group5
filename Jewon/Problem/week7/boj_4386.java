package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * boj_4386 별자리 만들기 골드 3
 * 
 * @author elder
 *
 */

public class boj_4386 {

	static int N;

	static class Vertex implements Comparable<Vertex> {
		int end;
		double weight;

		public Vertex(int end, double weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}

	}

	static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		public double get_dist(Point p) {
			return Math.pow(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2), 0.5) ;
		}
	}

	static List<Vertex>[] adjList;
	static Point[] stars;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		visit = new boolean[N];

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		stars = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());

			stars[i] = new Point(a, b);
		}

		for (int i = 0; i < stars.length; i++) {
			for (int j = i + 1; j < stars.length; j++) {
				double dist = stars[i].get_dist(stars[j]);
				adjList[i].add(new Vertex(j, dist));
				adjList[j].add(new Vertex(i, dist));
			}
		}

		//
//		for (int i = 0; i < adjList.length; i++) {
//			System.out.println(Arrays.toString(adjList[i].toArray()));
//		}

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(new Vertex(0, 0));
		double sum = 0;

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visit[v.end]) {
				continue;
			}

			visit[v.end] = true;
			sum += v.weight;

			for (Vertex next : adjList[v.end]) {
				if (!visit[next.end]) {
					q.offer(next);
				}
			}
//			System.out.println(Arrays.toString(q.toArray()));
		}

		System.out.println(sum);
	}

}
