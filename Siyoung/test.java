package assign;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int c = n*n;
		System.out.println(n +" "+n);
		for(int i = 0; i<n; i++) {
			for(int J = 0; J<n; J++) {
				System.out.print(c--+" ");
			}
			System.out.println();

		}
		
	}

}
