package se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일이삼더하기6 {
	static int t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n+3];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 2;
			
			for(int i=4; i<=n; i++) {
				
				if(i%2!=0) {
					arr[i] = arr[i-2]+arr[i-4];
				}
				else {
					arr[i] = arr[i-1]+arr[i-2];
				}
			}
			System.out.println(arr[n]);
		}
		
	}
	
}

