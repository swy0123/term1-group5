import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class sat_beak_11729 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, n) - 1);
        sb.append("\n");
        hanoi(n,1,2,3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void hanoi(int n, int start, int via, int to) throws IOException {
        if (n == 1) {
            move(start, to);
        } else {
            hanoi(n - 1, start, to, via);
            move(start, to);
            hanoi(n - 1, via, start, to);
        }
    }

    private static void move(int start, int to) {
        sb.append(start);
        sb.append(" ");
        sb.append(to);
        sb.append("\n");
    }
}
