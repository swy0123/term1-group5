package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 * boj_2941 크로아티아 알파벳 실버5
 * 
 * @author elder
 *
 */
public class boj_2941 {
	static HashMap<String, Integer> hmap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		hmap.put("c=", 1);
		hmap.put("c-", 1);
		hmap.put("dz=", 1);
		hmap.put("d-", 1);
		hmap.put("lj", 1);
		hmap.put("nj", 1);
		hmap.put("s=", 1);
		hmap.put("z=", 1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
//		StringBuilder sb = new StringBuilder();

		char temp;
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			// check
			if ((i + 1) < str.length() && hmap.get(str.substring(i, i + 2)) != null) {
				i += 1;
			} else if ((i + 2) < str.length() && hmap.get(str.substring(i, i + 3)) != null) {
				i += 2;
			}
			cnt++;
		}

		System.out.println(cnt);

	}

}
