import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        String s = br.readLine();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = i; j < length; j++) {
                char c = s.charAt(j);
                if (c == '<') {
                    word.reverse();
                    res.append(word);
                    word.setLength(0);
                    int k = j;
                    while (s.charAt(k) != '>') k++;
                    res.append(s, j, k + 1);
                    i = k;
                    break;
                }
                else if (c == ' ') {
                    word.reverse();
                    res.append(word).append(' ');
                    word.setLength(0);
                    i = j;
                    break;
                }
                else if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
                    word.append(c);
                    if (j == length - 1) {
                        word.reverse();
                        res.append(word);
                        i = length - 1;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
