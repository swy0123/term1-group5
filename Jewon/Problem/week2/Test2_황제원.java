
public class Test2_황제원 {

	public static void main(String[] args) {

		int[] su = { 45, 80, 68, 19, 34, 55, 27, 63, 38, 7 };

		int sum = 0;
		double diff = 0;
		int diffv = 0;

		for (int i = 0; i < su.length; i++) {
			sum += su[i];
		}

		double avg = (double) sum / su.length;

		for (int i = 0; i < su.length; i++) {
			if (diff < Math.abs(avg - su[i])) {
				diff = Math.abs(avg - su[i]);
				diffv = su[i];
			}
		}

		// 실수 소수점 첫번째 까지
		System.out.printf("%.1f %d ", avg, diffv);
	}
}
