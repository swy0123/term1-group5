import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sat_beak_12919 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        recursive(s, t);
        System.out.println(0);
    }

    private static void recursive(String str, String t) {

        if (str.length() == t.length()) {
            if (str.equals(t)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            recursive(str, t.substring(0, t.length() - 1));
        }
        if (t.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(t);
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            recursive(str, sb.toString());
        }
    }
}
