public class Test2_권민정 {

	public static void main(String[] args) {

		int[]  su=  {45, 80, 68, 19, 34, 55, 27, 63, 38, 7 };
		float avg = 0f, maxGap = 0f;
		int val = 0;	// 차이가 가장 큰 값
		
		for (int i = 0; i < su.length; i++) avg += su[i];
		avg /= su.length;
		
		for (int i = 0; i < su.length; i++) {
			if (maxGap < Math.abs(avg - su[i])) {
				maxGap = Math.abs(avg) - su[i];
				val = su[i];
			}
		}
		
		System.out.printf("%.1f %d", avg, val);
	}
}
