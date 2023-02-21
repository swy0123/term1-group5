package assign;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 백준 [실버2]창고다각형
 * @author SSAFY
 *
 */
public class fri_baek_2304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[1001];
		Arrays.fill(arr, 0);

		int l, h;
		int max = 0, maxIdx = 0, m = 0;
		for (int i = 0; i < n; i++) {
			l = sc.nextInt();
			h = sc.nextInt();
			arr[l-1] = h;
			if(max < h) {
				max = h;
				maxIdx = l-1;
			}
			if(m < l) {
				m = l;
			}
		}

		
		int sum = 0, cur = 0;
		maxIdx--;
		m--;
		for(int i=0; i<=maxIdx; i++) {
			if(arr[i]>cur){
				cur = arr[i];
			}
			sum += cur;
		}
		cur = 0;
		for(int i=m; i>maxIdx; i--) {
			if(arr[i]>cur){
				cur = arr[i];
			}
			sum += cur;
		}
		
		System.out.println(sum);
		
	}

}
