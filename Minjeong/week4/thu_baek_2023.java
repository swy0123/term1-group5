import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> s = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        find(0, 0);
        System.out.println(sb.toString());
    }
    
    private static void find(int num, int cnt) {
    	if (cnt == n) {
    		sb.append(num).append('\n');
    		return;
    	}
    	
    	for (int i = 1; i <= 9; i++) {
    		int t = i + 10 * num;
    		if (s.contains(t)) find(t, cnt + 1);
    		else if (isPrimeNum(t)) {
    			s.add(t);
    			find(t, cnt + 1);
    		}
    	}
    }

	private static boolean isPrimeNum(int tmp) {
		if (tmp == 1) return false;
		for (int i = 2; i * i <= tmp; i++) {
			if (tmp % i == 0) return false;
		}
		return true;
	}
}
