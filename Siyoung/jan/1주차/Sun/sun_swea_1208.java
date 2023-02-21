package com.sy.firstweek.sun;

import java.util.Scanner;
/**
 * 문제18: 1208 Flatten ( 배열 연습 입문 ) 1
 * @author swy05
 */
public class sun_swea_1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int d;
		int min, max, minIdx, maxIdx;
		
		for(int t=1; t<=10; t++) {
			d = sc.nextInt();
			int[] arr = new int[100];
			
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			min = 101;
			max = 0;
			for(int i=0; i<d; i++) {
				min = 101;
				max = 0;
				minIdx = 0;
				maxIdx = 0;
			
				for(int j=0; j<100; j++) {
					if(arr[j]>max) {
						max = arr[j];
						maxIdx = j;
					}
					if(arr[j]<min) {
						min = arr[j];
						minIdx = j;
					}	
				}
				arr[minIdx]++;
				arr[maxIdx]--;
				
			}
			min = 101;
			max = 0;
			for(int j=0; j<100; j++) {
				if(arr[j]>max) {
					max = arr[j];
				}
				if(arr[j]<min) {
					min = arr[j];
				}
			}
			
			System.out.println("#" + t + " " + (max-min));
		}

	}

}
