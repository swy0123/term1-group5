import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int s, p;
	static String DNA;
	static int res;
	static Map<Character, Integer> m = new HashMap<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        DNA = br.readLine();
        st = new StringTokenizer(br.readLine());
        m.put('A', Integer.parseInt(st.nextToken()));
        m.put('C', Integer.parseInt(st.nextToken()));
        m.put('G', Integer.parseInt(st.nextToken()));
        m.put('T', Integer.parseInt(st.nextToken()));
        
        String tmp = DNA.substring(0, p);
        int a, c, g, t;
    	a = c = g = t = 0;
    	for (int j = 0; j < p; j++) {
    		switch (tmp.charAt(j)) {
        		case 'A':
        			a++;
        			break;
        		case 'C':
        			c++;
        			break;
        		case 'G':
        			g++;
        			break;
        		case 'T':
        			t++;
        			break;
    		}
    	}
    	if (a >= m.get('A') && c >= m.get('C') && g >= m.get('G') && t >= m.get('T')) {
			res++;
		}
        for (int i = p, j = 0; i < s; i++, j++) {
        	char c1, c2;
        	c1 = DNA.charAt(j);
        	c2 = DNA.charAt(i);
        	switch (c1) {
	        	case 'A':
	        		a--;
	        		break;
	        	case 'C':
	        		c--;
	        		break;
	        	case 'G':
	        		g--;
	        		break;
	        	case 'T':
	        		t--;
	        		break;
        	}
        	switch (c2) {
	        	case 'A':
	        		a++;
	        		break;
	        	case 'C':
	        		c++;
	        		break;
	        	case 'G':
	        		g++;
	        		break;
	        	case 'T':
	        		t++;
	        		break;
        	}
        	if (a >= m.get('A') && c >= m.get('C') && g >= m.get('G') && t >= m.get('T')) {
    			res++;
    		}
        }
        System.out.println(res);
    }
}
