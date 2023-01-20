package com.sy.firstweek;

import java.util.Scanner;

public class thu_swea_1234 {
	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
        for(int testCase = 1; testCase <= 10; testCase++) {
        	
            int n = sc.nextInt();
            String str = sc.next();
 
            int idx = 0;
            while (idx<str.length()-1) {
            	if (str.charAt(idx) == str.charAt(idx+1)) {
                    String tmp = str.substring(idx, idx + 2);
                    str = str.replace(tmp, "");
                    idx=0;
                }
            	else idx++;
            }
 
            System.out.println("#" + testCase + " " + str);
        }
    }
	
}
