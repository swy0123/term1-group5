import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class fri_beak_1107 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maskSize = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        StringTokenizer st;
        if (maskSize != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < maskSize; i++) {
                set.add(st.nextToken().charAt(0));
            }
        }

        int minValue = Math.abs(n - 100);

        label:
        for (int i = 0; i < 5000000; i++) {
            String toStr = Integer.toString(i);
            for (char c : toStr.toCharArray()) {
                if (set.contains(c)) {
                    continue label;
                }
            }

            minValue = Math.min(Math.abs(n - i) + toStr.length(), minValue);
        }
        System.out.println(minValue);
    }
}
