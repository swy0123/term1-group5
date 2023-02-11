import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String res;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) s.append(9);
        res = s.toString();
        find(0, 0, new StringBuilder());
        System.out.println(res);
    }

    private static void find(int depth, int cur, StringBuilder seq) {
        if (depth == n) {
            if (seq.toString().compareTo(res) < 0) {
                res = seq.toString();
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (i == cur) continue;
            seq.append(i);
            if (isBadSeq(seq.toString())) {
                seq.deleteCharAt(depth);
                continue;
            }
            find(depth + 1, i, seq);
            seq.deleteCharAt(depth);
            if (flag) return;
        }
    }

    private static boolean isBadSeq(String seq) {
        for (int gap = 1; gap <= seq.length() / 2; gap++) {
            for (int i = 0; i <= seq.length() - gap * 2; i++) {
                String tmp1 = seq.substring(i, i + gap);
                String tmp2 = seq.substring(i + gap, i + gap + gap);
                if (tmp1.equals(tmp2)) return true;
            }
        }
        return false;
    }
}

