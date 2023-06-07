import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	String[] letters = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder tmp = new StringBuilder();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
        	boolean flag = false;
        	int n = 0;
        	tmp.append(s.charAt(i));
        	for (String string : letters) {
				if (tmp.toString().contains(string)) {
					flag = true;
					n = string.length();
					break;
				}
			}
            if (flag) {
            	res += tmp.length() - n + 1;
            	tmp.setLength(0);
            	continue;
            }
            if (i == s.length() - 1) res += tmp.length();
        }

        System.out.println(res);
    }
}