import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class sun_beak_2999 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int len = input.length();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(len); i++) {
            if (len % i == 0) {
                list.add(i);
            }
        }
        int c = list.get(list.size() - 1);
        int r = len / c;

        char[][] table = new char[c][r];

        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                table[j][i] = input.charAt(index);
                index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : table) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
        }
        System.out.println(sb.toString());
    }
}
