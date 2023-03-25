package feb.week2.sat;

import java.util.Arrays;
import java.util.Scanner;

public class sat_baek_3040 {
		static int[] arr;
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			 arr = new int[9];
			
			for(int i=0; i<9; i++) {
				arr[i] = sc.nextInt();
			}
			com(new boolean[9], 0, 0);
			

		}
		
		private static void com(boolean[] v, int idx, int cnt) {
			if(idx-cnt > 2) return;
			if(idx == 9) {
				if(cnt==7) {
					int sum = 0;
					for(int i=0; i<9; i++) {
						if(v[i]) {
							sum+=arr[i];
						}
					}
					if(sum != 100) return;
					for(int i=0; i<9; i++) {
						if(v[i]) {
							System.out.println(arr[i]);
						}
					}
				}
				return;
			}

//			v[idx] = false;
			com(v, idx+1, cnt);
			v[idx] = true;
			com(v, idx+1, cnt+1);
		}

	}
