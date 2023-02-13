
public class Test2_이시영 {

	public static void main(String[] args) {

		int[]  su=  {45, 80, 68, 19, 34, 55, 27, 63, 38, 7 };
		
		int sum = 0;
		float avg, abs;
		
		for(int i=0; i<su.length; i++) {
			sum += su[i];
		}
		
		avg = (float)sum/su.length;
		abs = avg;
		for(int i=0; i<su.length; i++) {
			if(Math.abs(avg-su[i])>Math.abs(avg-abs)) {
				abs = su[i];
			}
		}
		System.out.printf("%.1f %d\n", avg, (int)abs);
		

	}
}
