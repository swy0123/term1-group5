import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        String s = br.readLine();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '<') {
                word.reverse();
                res.append(word);
                word.setLength(0);
                int j = i;
                while (s.charAt(j) != '>') j++;
                res.append(s, i, j + 1);
                i = j;
            }
            else if (c == ' ') {
                word.reverse();
                res.append(word).append(' ');
                word.setLength(0);
            }
            else if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
                word.append(c);
                if (i == length - 1) {
                    word.reverse();
                    res.append(word);
                }
            }
        }
        System.out.println(res);
    }
}
