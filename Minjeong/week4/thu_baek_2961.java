import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Ingredient {
	int s;
	int b;
	
	public Ingredient(int s, int b) {
		this.s = s;
		this.b = b;
	}
}

public class Main {
	static int n;
	static int res = Integer.MAX_VALUE;
	static Ingredient[] items;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        items = new Ingredient[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
			items[i] = new Ingredient(s, b);
		}
        
        solve(0, 1, 0, 0);
        System.out.println(res);
    }
    
    private static void solve(int idx, int s, int b, int cnt) {
    	if (idx == n) {
    		if (cnt != 0) {
    			res = Math.min(res, Math.abs(s - b));
    		}
    		return;
    	}
    	
    	solve(idx + 1, s, b, cnt);
    	solve(idx + 1, s * items[idx].s, b + items[idx].b, cnt + 1);
    }
}
