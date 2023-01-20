package com.sy;

import java.util.Scanner;

public class NoGlasses 
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		boolean dif = false;
		
		String b = "B";
		String a = "ADOPQR";
		String c = "CEFGHIJKLMNSTUVWXYZ";
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s1 = sc.next();
			String s2 = sc.next();
			dif = false;
			
			if(s1.length()!=s2.length()) {
				System.out.println("#" + test_case + " DIFF");
				continue;
			}
			
			for(int i=0; i<s1.length(); i++) {
				if(b.indexOf(s1.charAt(i))>=0 && b.indexOf(s2.charAt(i))>=0) continue;
				if(a.indexOf(s1.charAt(i))>=0 && a.indexOf(s2.charAt(i))>=0) continue;
				if(c.indexOf(s1.charAt(i))>=0 && c.indexOf(s2.charAt(i))>=0) continue;
				dif = true;
			}
			
			if(dif == true) System.out.println("#" + test_case + " DIFF");
			else System.out.println("#" + test_case + " SAME");
		}
	}
}
