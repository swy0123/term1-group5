package com.sy.jan.thirdweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class fri_baek_1520 {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] arr;
	static int[][] res;
	static boolean[][] check;
	static int n, m;
	static ArrayList<int[]> temp = new ArrayList();
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        res = new int[n][m];
        check = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
                res[i][j] = -1;
            }
        }
        dfs(0, 0);

//        for(int i=0; i<n; i++) {
//            for(int j=0; j<m; j++) {
//            	System.out.print(res[i][j] +" ");
//            }
//            System.out.println();
//        }
        System.out.println(res[0][0]);

    }
    
    private static int dfs(int i, int j) {
    	if(i == n-1 && j == m-1) {
    		res[i][j] = 1;
    		check[i][j] = true;
    		return 1;
    	}
    	if(check[i][j]) {
    		return res[i][j];
    	}
    	check[i][j] = true;
    	
    	res[i][j] = 0;
    	for(int k=0; k<4; k++) {
    		if(i+di[k] >=0 && i+di[k]<n && j+dj[k]>=0 && j+dj[k]<m) {
    			if(arr[i][j] > arr[i+di[k]][j+dj[k]]) {
    				res[i][j] += dfs(i+di[k], j+dj[k]);
    			}
    		}
    	}
    	return res[i][j];
    	
    	
    }
   
    

    
}  