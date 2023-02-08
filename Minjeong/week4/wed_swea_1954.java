import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for (int testCase = 1; testCase <= T; testCase++) {
    		int n = Integer.parseInt(br.readLine());
    		int len = n;
    		int[][] arr = new int[n][n];
    		int val = 1, loopSize = (n + 1) / 2;
    		for (int t = 0; t <= loopSize; t++) {
    			// 상
    			for(int i = t; i < t + len - 1; i++) arr[t][i] = val++;
    			// 우
    			for(int i = t; i < t + len - 1; i++) arr[i][t + len - 1] = val++;
    			// 하
    			for(int i = t + len - 1; i >= t + 1; i--) arr[t + len - 1][i] = val++;
    			// 좌
    			for(int i = t + len - 1; i >= t + 1; i--) arr[i][t] = val++;
    			len -= 2;
    		}
    		if (n % 2 == 1) arr[n / 2][n / 2] = val;
    		System.out.println("#" + testCase + " ");
    		print(arr);
    	}
    }
    
    private static void print(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
    }
}