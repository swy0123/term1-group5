package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * 창고 다각형 2304번 Silver 2
 * 
 * @author elder
 *
 */
public class BEAK_2304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> hMap = new HashMap<>();

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			hMap.put(sc.nextInt(), sc.nextInt());
		}
		
		List<Entry<Integer,Integer>> list = new ArrayList<>();
		
		for(Entry<Integer,Integer> entryset : hMap.entrySet()) {
			list.add(entryset);
		}
		
//		Set<Entry<Integer, Integer>> entryList = hMap.entrySet();

//		Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {
//
//			@Override
//			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
//				// TODO Auto-generated method stub
//				return Integer.compare(o1.getKey(), o2.getKey());
//			}
//
//		});

		//System.out.println(entryList.toString());
	}

}
