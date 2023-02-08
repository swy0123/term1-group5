package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 
 * boj_11729 하노이탑 이동순서 실버1
 * 
 * @author elder
 *
 */
public class boj_11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		hanoi(1, 3, N);
		bw.flush();
	}

	private static void hanoi(int start, int dest, int n) throws IOException {
		// TODO Auto-generated method stub
		if (n == 0)
			return;

		int temp = 6 - start - dest;
		hanoi(start, temp, n - 1);
		bw.write(start + " " + dest + "\n");
		hanoi(temp, dest, n - 1);
	}

}

// n-1개를 2번으로
// n을 3번
// n-1을 3번으로

// 1 3 2
// 2 3 1
// 2 1 3
