package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_10775 공항 골드2
 * 
 * @author SSAFY
 *
 */
public class boj_10775 {

	static int[] Gates;
	static boolean[] b_Gates;
	static int G;
	static int P;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());

		Gates = new int[G + 1];
//		b_Gates
		for (int i = 0; i < Gates.length; i++) {
			Gates[i] = i;
		}
		
		for (int i = 0; i < P; i++) {
			int value = Integer.parseInt(br.readLine());
			int root = find(value);
			if(root != 0) {
				union(root);
			}else {
				System.out.println(cnt);
				System.exit(0);
			}
		}
		
		System.out.println(cnt);
	}

	private static void union(int value) {	
		cnt++;
		Gates[value] = find(value-1);
	}

	private static int find(int value) {
		if(Gates[value] == value) {
			return value;
		}else {
			// path compression
			return Gates[value] = find(Gates[value]);			
		}
	}

}
