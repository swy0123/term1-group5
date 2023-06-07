package se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		String pattern = br.readLine();
		
		KMP(text, pattern);
		System.out.println(arr.size());
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
	
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		
		int j=0;
		for(int i=1; i<pattern.length(); i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		System.out.println(Arrays.toString(pi));
		return pi;
	}
	static void KMP(String parent, String pattern) {
		int[] table = getPi(pattern);
		
		int j = 0; 
		for(int i = 0 ; i< parent.length(); i++) {
			while(j >0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if(parent.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					arr.add((i-pattern.length()+1)+1);
					j = table[j];
				}else {
					j++;
				}
			}
		}
		
	}
	
}

