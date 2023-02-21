package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 문제7 : 백준 : 17413 단어 뒤집기 2
 * @author swy05\
 */
public class sat_baek_17413 {
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
    	String ret = "";
    	String cur = "";
    	boolean flag = false;
    	
    	for(int i=0; i<str.length(); i++) {
    		char tmp = str.charAt(i);
    		if(tmp=='<') {
    			flag = true;
    			
    			if(!cur.isEmpty()) {
    				for(int j=cur.length()-1; j>=0; j--) {
    					ret += String.valueOf(cur.charAt(j));
    				}
    				cur = "";
    			}
    			
    			ret += String.valueOf(tmp);
    			continue;
    		}
    		if(tmp=='>') {
    			flag = false;
    			ret += String.valueOf(tmp);
    			continue;
    		}
    		if(flag) {
    			ret += String.valueOf(tmp);
    		}
    		else if(tmp==' ') {
    			if(!cur.isEmpty()) {
    				for(int j=cur.length()-1; j>=0; j--) {
    					ret += String.valueOf(cur.charAt(j));
    				}
    				cur = "";
    			}
    			ret += " ";
    		}
    		else {
    			cur += String.valueOf(tmp);
    		}
    	}
    	if(!cur.isEmpty()) {
			for(int j=cur.length()-1; j>=0; j--) {
				ret += String.valueOf(cur.charAt(j));
			}
			cur = "";
		}
    	
        System.out.println(ret);
    }
}
