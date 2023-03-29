package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ssafy_Apt {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] memob = new int[num + 1];
		int[] memoy = new int[num + 1];

		memob[1] = 1;
		memoy[1] = 1;

		for (int i = 2; i < num + 1; i++) {
			memoy[i] = memob[i-1] + memoy[i-1];
			memob[i] = memoy[i-1];
		}

		System.out.println(memoy[num] + memob[num]);
	}

}
